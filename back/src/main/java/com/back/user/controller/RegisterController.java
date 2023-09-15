package com.back.user.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.back.user.repository.UserDto;
import com.back.user.service.RegisterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@ResponseBody
@CrossOrigin("http://localhost:3000")
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {
	  
	private final RegisterService registerService;
	
	//ID 중복확인
	@GetMapping("/idCheck")
	public Boolean idCheck(@RequestParam(name = "userId") String userId) {
		log.info("idCheck 확인");
		 boolean result = registerService.idCheck(userId);
		 return result;
	}
	
	//회원가입
	@PostMapping("/userJoin")
	public int userJoin(@RequestBody UserDto uDto) {
		log.info("memberInsert 확인");
		   // 비밀번호 암호화
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(uDto.getUserPw());
        uDto.setUserPw(encodedPassword);
		int result = registerService.userJoin(uDto);
		return result;
	}
	
	//회원 탈퇴
	@PostMapping("/withdraw")
	public int withdraw(@RequestBody UserDto uDto) {
		log.info("withdraw 확인");
		int result = registerService.withdraw(uDto);
		return result;
	}

	
}