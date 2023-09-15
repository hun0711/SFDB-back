package com.back.user.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDto {

	private int userNo; //pk
	private String userId;
	private String userPw;
	private String userName;
	private String userBirth;
	private String userEmail;
	private String userProfileImage;
}