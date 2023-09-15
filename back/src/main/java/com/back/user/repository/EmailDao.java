package com.back.user.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailDao {

	int releaseNoticeEmail(Map<String, String> requestData);

	boolean existReleaseNoticeEmailUser(String userId);

}
