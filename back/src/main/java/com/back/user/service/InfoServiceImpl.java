package com.back.user.service;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.back.user.controller.InfoController;
import com.back.user.repository.InfoDao;
import com.back.user.repository.LoginDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService {
       private final InfoDao infoDao;

	@Override
	public int changeUserName(Map<String, String> requestData) {
		log.info("InfoServiceImpl : changeUserName 호출");
		int result = infoDao.changeUserName(requestData);
		return result;
	}

	@Override
	public int updateProfileImage(Map<String, String> requestData) {
		log.info("InfoServiceImpl : updateProfileImage 호출");
		int result = infoDao.updateProfileImage(requestData);
		return result;
	}

	@Override
	public String findIdByUserNameAndEmail(Map<String, String> userData) {
		log.info("InfoServiceImpl : findIdByUserNameAndEmail 호출");
		String userId = infoDao.findIdByUserNameAndEmail(userData);
		return userId;
	}

	@Override
	public String findPwByUserNameAndIdAndEmail(Map<String, String> userData) {
		log.info("InfoServiceImpl : findPwByUserNameAndIdAndEmail 호출");
		String userPw = infoDao.findPwByUserNameAndIdAndEmail(userData);
		return userPw;
	}

	@Override
	public void updateUserPassword(String userId, String encodedPassword) {
		log.info("InfoServiceImpl : updateUserPassword 호출");
		infoDao.updateUserPassword(userId, encodedPassword);
		
	}


	@Override
	public String getEncryptedPassword(String userId) {
		log.info("InfoServiceImpl : getEncryptedPassword 호출");
		 return infoDao.getEncryptedPassword(userId);
	}


	@Override
	public int changeUserPw(String userId, String encodedNewPassword) {
		log.info("InfoServiceImpl : checkUserPw 호출");
		 return infoDao.changeUserPw(userId, encodedNewPassword);
	}
	

}
