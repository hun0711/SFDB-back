package com.back.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.back.user.repository.EmailDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
	private final EmailDao emailDao;
	
	@Override
	public int releaseNoticeEmail(Map<String, String> requestData) {
    log.info("EmailServiceImpl : releaseNoticeEmail 호출");
    int result = emailDao.releaseNoticeEmail(requestData);
	return result;
	}

	@Override
	public boolean existReleaseNoticeEmailUser(String userId) {
		log.info("EmailServiceImpl : existReleaseNoticeEmailUser 호출");
		boolean result = emailDao.existReleaseNoticeEmailUser(userId);
		return result;
	}

}
