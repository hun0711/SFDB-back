package com.back.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface InfoService {

    //이름 변경
	int changeUserName(Map<String, String> requestData);

	//프사 변경
	int updateProfileImage(Map<String, String> requestData);

	//id 찾기(이름,이메일)
	String findIdByUserNameAndEmail(Map<String, String> userData);

	//pw 찾기(이름,이메일)
	String findPwByUserNameAndIdAndEmail(Map<String, String> userData);

	//pw 변경(임시 비밀번호 발급)
	void updateUserPassword(String userId, String encodedPassword);
	
	//암호화 pw 반환
	String getEncryptedPassword(String userId);

	//pw 변경(유저 프로필에서 변경)
	int changeUserPw(String userId, String encodedNewPassword);


}
