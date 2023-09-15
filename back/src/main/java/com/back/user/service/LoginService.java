package com.back.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.user.repository.UserDto;

@Service
public interface LoginService {


	UserDto getUserByGoogleId(String googleId);

	UserDto getUserByNaverId(String naverId);

	UserDto getUserByKakaoId(String kakaoId);

	String getEncryptedPassword(String userId);

	List<UserDto> userInfo(String userId);
	
}