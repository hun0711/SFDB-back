package com.back.user.controller;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.back.user.repository.UserDto;
import com.back.user.service.InfoService;
import com.back.user.service.LoginService;
import com.back.user.service.RegisterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@ResponseBody
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class InfoController {
	private final InfoService infoService;


	//이름 변경
	@PostMapping("/changeUserName")
	public int changeUserName(@RequestBody Map<String, String> requestData) {
	    log.info("InfoController : changeUserName 호출");
	    int result = infoService.changeUserName(requestData);
	    return result;
	}
	//이미지 변경
	@PostMapping("/updateProfileImage")
	public int updateProfileImage(@RequestBody Map<String, String> requestData) {
		log.info("InfoController : updateProfileImage 호출");
		int result = infoService.updateProfileImage(requestData);
		return result;
	}
	
	//비밀번호 변경
	@PostMapping("/changePw")
	public int changePw(@RequestBody Map<String, String> requestData) {
	  log.info("InfoController : changePw 호출");	
	  String userId = requestData.get("userId");
	  String userPw = requestData.get("userPw");
	  String userChangePw = requestData.get("userChangePw");
      String getUserPw = infoService.getEncryptedPassword(userId);
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      if (encoder.matches(userPw, getUserPw)) { //기존 비밀번호와 일치시
    	  log.info("비밀번호 일치 확인");
    	  String encodedNewPassword = encoder.encode(userChangePw); //변경할 비밀번호 암호화
    	  int result = infoService.changeUserPw(userId , encodedNewPassword);
    	  return result;
      }else {
    	  log.info("비밀번호 불일치");
    	  return 0;
      }
	}
	
}
