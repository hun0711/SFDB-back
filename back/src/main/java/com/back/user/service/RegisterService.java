package com.back.user.service;

import org.springframework.stereotype.Service;

import com.back.user.repository.UserDto;

@Service
public interface RegisterService {
	
     	//id 중복확인
		boolean idCheck(String userId);

		//회원 가입
		int userJoin(UserDto uDto);

		//회원 탈퇴
		int withdraw(UserDto uDto);


}