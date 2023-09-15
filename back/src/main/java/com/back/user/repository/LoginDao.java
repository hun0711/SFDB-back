package com.back.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

	//로그인
	public String findEncryptedPasswordByUserId(String userId);
	
	//로그인 후 회원정보
	public List<UserDto> userInfo(String userId);

	//구글 회원 존재여부 확인
	public UserDto findByGoogleId(String googleId);

	//네이버 회원 존재여부 확인
	public UserDto findByNaverId(String naverId);

	//카카오 회원 존재여부 확인
	public UserDto findByKakaoId(String kakaoId);


}