package com.back.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.back.api.repository.MovieDto;
import com.back.user.repository.UserDto;
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
public class LoginController {
	private final LoginService loginService;
	private final RegisterService registerService;

	
	//로그인
	@PostMapping("/login")
	public int userLogin(@RequestBody UserDto uDto) {
		log.info("유저 로그인 호출");
		 String storedEncryptedPassword = loginService.getEncryptedPassword(uDto.getUserId()); // 저장된 암호화된 비밀번호 조회
		 // 입력한 로그인 비밀번호를 해싱하여 암호화된 비밀번호와 비교
		  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		  String inputPassword = uDto.getUserPw();
        if (encoder.matches(inputPassword, storedEncryptedPassword)) {
           return 1;  
        }else {
        	return 0;
        }
	}
	
	//로그인 후 유저 정보
	@GetMapping("/userInfo")
	public List<UserDto> userInfo(String userId) {
		log.info("유저 정보 호출");
		List<UserDto> userInfo = loginService.userInfo(userId);
		return userInfo; 
	}
	
	
	//구글로그인
	@PostMapping("/login/google")
	public int googleSocialLogin(@RequestBody Map<String, String> googleLoginData, HttpServletRequest request) {
		  log.info("구글 소셜 로그인 호출");
	        try {
	            HttpSession session = request.getSession(true);
	            String googleId = googleLoginData.get("id");
	            String googleName = googleLoginData.get("name");
	            String googleEmail = googleLoginData.get("email");
	            String googleImage = googleLoginData.get("picture");
	            // 데이터베이스에서 해당 네이버 ID로 등록된 사용자가 있는지 확인
	            UserDto existingUser = loginService.getUserByGoogleId(googleId);

	            if (existingUser != null) {
	                // 기존 사용자라면 세션 정보를 업데이트
	                session.setAttribute("userId", existingUser.getUserId());
	            } else {
	                // 새로운 사용자라면 새로운 사용자 정보를 생성하여 데이터베이스에 등록
	                UserDto newUser = new UserDto();
	                newUser.setUserId(googleId);
	                newUser.setUserName(googleName);
	                newUser.setUserEmail(googleEmail);
	                newUser.setUserProfileImage(googleImage);

	                // 새로운 사용자를 데이터베이스에 등록
	                registerService.userJoin(newUser);

	                // 새로운 사용자의 세션 정보를 업데이트
	                session.setAttribute("userId", newUser.getUserId());
	            }
	      	  return 1;
	        } catch (Exception e) {
	            // 로그인 실패에 대한 처리
	            log.error("구글 소셜 로그인 실패:", e);
	            return 0;
	        }
	}
	

	
	//네이버로그인
	@PostMapping("/login/naver")
	public int naverSocialLogin(@RequestBody Map<String, String> naverLoginData, HttpServletRequest request) {
		log.info("네이버 소셜 로그인 호출");
      try {
    	  HttpSession session = request.getSession(true);
    	  String naverId = naverLoginData.get("id");
    	  String naverName = naverLoginData.get("name");
    	  String naverEmail = naverLoginData.get("email");
    	  String naverBirth = naverLoginData.get("birthday");
    	  String naverImage = naverLoginData.get("profile_image");
    	  
          // 데이터베이스에서 해당 네이버 ID로 등록된 사용자가 있는지 확인
          UserDto existingUser = loginService.getUserByNaverId(naverId);

          if (existingUser != null) {
              // 기존 사용자라면 세션 정보를 업데이트
              session.setAttribute("userId", existingUser.getUserId());
          } else {
              // 새로운 사용자라면 새로운 사용자 정보를 생성하여 데이터베이스에 등록
              UserDto newUser = new UserDto();
              newUser.setUserId(naverId);
              newUser.setUserName(naverName);
              newUser.setUserEmail(naverEmail);
              newUser.setUserBirth(naverBirth);
              newUser.setUserProfileImage(naverImage);

              // 새로운 사용자를 데이터베이스에 등록
              registerService.userJoin(newUser);

              // 새로운 사용자의 세션 정보를 업데이트
              session.setAttribute("userId", newUser.getUserId());
          }
    	  return 1;
      }catch (Exception e) {
    	  log.error("네이버 소셜 로그인 실패:" , e);
    	  return 0;
      }
	}

	
	// 카카오로그인 
	  @PostMapping("/login/kakao")
	  public int kakaoSocialLogin(@RequestBody Map<String, String> kakaoLoginData, HttpServletRequest request) {
	    log.info("Kakao 소셜 로그인 호출");
	    try {
	      HttpSession session = request.getSession(true);
	      String kakaoId = kakaoLoginData.get("id");
	      String kakaoName = kakaoLoginData.get("name");
	      String kakaoEmail = kakaoLoginData.get("email");
	      String kakaoBirth = kakaoLoginData.get("birth");
	      String kakaoImage = kakaoLoginData.get("image");
	      
	   // 데이터베이스에서 해당 네이버 ID로 등록된 사용자가 있는지 확인
          UserDto existingUser = loginService.getUserByKakaoId(kakaoId);

          if (existingUser != null) {
              // 기존 사용자라면 세션 정보를 업데이트
              session.setAttribute("userId", existingUser.getUserId());
	      }else {
	    	  // 새로운 사용자라면 새로운 사용자 정보를 생성하여 데이터베이스에 등록
              UserDto newUser = new UserDto();
              newUser.setUserId(kakaoId);
              newUser.setUserName(kakaoName);
              newUser.setUserEmail(kakaoEmail);
              newUser.setUserBirth(kakaoBirth);
              newUser.setUserProfileImage(kakaoImage);
	    	  session.setAttribute("userId", kakaoId);
	    	  
	    	  // 새로운 사용자를 데이터베이스에 등록
              registerService.userJoin(newUser);
              
           // 새로운 사용자의 세션 정보를 업데이트
              session.setAttribute("userId", newUser.getUserId());
	      }
	      return 1;
	    } catch (Exception e) {
	      log.error("Kakao 소셜 로그인 실패:", e);
	      return 0;
	    }
	  }
}