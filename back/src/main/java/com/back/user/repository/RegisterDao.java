package com.back.user.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {
	
	//id 중복체크
	public boolean idCheck(String userId);
	

	// 회원 가입
    public int userJoin(UserDto uDto);


    //회원 탈퇴
	public int withdraw(UserDto uDto);


}