package com.back.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

	int releaseNoticeEmail(Map<String, String> requestData);

	boolean existReleaseNoticeEmailUser(String userId);

}
