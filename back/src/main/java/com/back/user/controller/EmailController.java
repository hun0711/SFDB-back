package com.back.user.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.back.user.repository.UserDto;
import com.back.user.service.EmailService;
import com.back.user.service.InfoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@ResponseBody
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class EmailController {
	private final InfoService infoService;
	private final EmailService emailService;
    private final JavaMailSender javaMailSender;
    private final TaskScheduler taskScheduler;
    private final TemplateEngine templateEngine;
    
    @GetMapping("/existReleaseNoticeEmailUser")
    public Boolean existReleaseNoticeEmailUser(@RequestParam(name = "userId") String userId) {
    	log.info("EmailController : existReleaseNoticeEmailUser 호출");
    	boolean result = emailService.existReleaseNoticeEmailUser(userId);
    	return result;
    }
    
    
    @PostMapping("/releaseNoticeEmail")
    public int releaseNoticeEmail(@RequestBody Map<String, String> requestData) throws IOException {
        log.info("EmailController : releaseNoticeEmail 호출");
        try {
            String repRlsDateString = requestData.get("repRlsDate");
            LocalDate repRlsDate = LocalDate.parse(repRlsDateString, DateTimeFormatter.ISO_DATE);
            String userEmail = requestData.get("userEmail");
            String title = requestData.get("title");
            String posterUrls = requestData.get("posterUrls");
            String actorNms = requestData.get("actorNms");
            String plotText = requestData.get("plotText");

            // 메일 내용 생성
            String mailSubject = "[SFDB] 영화 " + title + " 개봉 알림";
            Context context = new Context();
            context.setVariable("title",title);
            context.setVariable("actorNms",actorNms);
            context.setVariable("plotText", plotText);
            context.setVariable("posterUrls", posterUrls);
            context.setVariable("title",title);
            String htmlContent = templateEngine.process("releaseNoticeEmail", context);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(userEmail);
            helper.setSubject(mailSubject);
            helper.setText(htmlContent, true);

            // 메일 전송
            Date scheduledDate = Date.from(repRlsDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            taskScheduler.schedule(() -> javaMailSender.send(mimeMessage), scheduledDate);
            int result = emailService.releaseNoticeEmail(requestData);
            return result;

        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    
    //id찾기
    @PostMapping("/findId")
    public int findId(@RequestBody Map<String, String> userData){
    	  log.info("EmailController : findId 호출");
          try {
              String userId = infoService.findIdByUserNameAndEmail(userData);
              String userName = userData.get("userName");
              String userEmail = userData.get("userEmail");
              
              if (userId != null) {
                  // userId가 존재하면 메일 발송
                  String mailSubject = "[SFDB] 회원님의 아이디 찾기 결과입니다.";
                  Context context = new Context();
                  context.setVariable("userName", userName);
                  context.setVariable("userId", userId);

                  String htmlContent = templateEngine.process("findId", context);

                  MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                  MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                  helper.setTo(userEmail);
                  helper.setSubject(mailSubject);
                  helper.setText(htmlContent, true);

                  System.out.println(htmlContent);
                  // 메일 전송
                  javaMailSender.send(mimeMessage);

                  return 1;
              } else {
                  // userId가 존재하지 않으면 0 반환
                  return 0;
              }
          } catch (MessagingException e) {
              e.printStackTrace();
              return 0;
          }

    }
    
    //pw찾기
    @PostMapping("/findPw")
    public int findPw(@RequestBody Map<String, String> userData){
    	log.info("EmailController : findPw 호출");
    	try {
    		UserDto uDto = new UserDto();
    		String userPw = infoService.findPwByUserNameAndIdAndEmail(userData);
    		
    		String userId = userData.get("userId");
    		String userName = userData.get("userName");
    		String userEmail = userData.get("userEmail");
    		
    		if (userPw != null) {
    			// 임시 비밀번호 생성
                String temporaryPassword = generateTemporaryPassword(); // 임시 비밀번호 생성 메소드 호출

                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String encodedPassword = encoder.encode(temporaryPassword);
                // userPw 업데이트
                infoService.updateUserPassword(userId, encodedPassword);
    		
                // userPw가 존재하면 메일 발송
    			String mailSubject = "[SFDB] 회원님의 비밀번호 찾기 결과입니다.";
    			Context context = new Context();
    			context.setVariable("userName", userName);
                context.setVariable("userId", userId);
                context.setVariable("temporaryPassword", temporaryPassword);
    			
                String htmlContent = templateEngine.process("findPw", context);
    			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
    			helper.setTo(userEmail);
    			helper.setSubject(mailSubject);
    			helper.setText(htmlContent, true);
    			
    			// 메일 전송
    			javaMailSender.send(mimeMessage);
    			
    			return 1;
    		} else {
    			// userPw가 존재하지 않으면 0 반환
    			return 0;
    		}
    	} catch (MessagingException e) {
    		e.printStackTrace();
    		return 0;
    	}
    	
    }
   // 임시 비밀번호 확인
  @GetMapping("/checkTempPw")
  public boolean checkTempPw(@RequestParam(name = "userId")String userId,@RequestParam(name = "tempPw")String tempPw) {
	  log.info("EmailController : checkTempPw 호출");
	  String storedEncryptedPassword = infoService.getEncryptedPassword(userId);
	  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	  return encoder.matches(tempPw, storedEncryptedPassword);
  }
    
    
 // 임시 비밀번호 생성
    private String generateTemporaryPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength = 8;
        Random random = new SecureRandom();
        
        StringBuilder password = new StringBuilder(passwordLength);
        
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            password.append(randomChar);
        }
        
        return password.toString();
    }
    
}
