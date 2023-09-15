package com.back.user.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InfoDao {


	public int changeUserName(Map<String, String> requestData);

	public int updateProfileImage(Map<String, String> requestData);

	public String findIdByUserNameAndEmail(Map<String, String> userData);

	public String findPwByUserNameAndIdAndEmail(Map<String, String> userData);

	public void updateUserPassword(@Param("userId")String userId, @Param("encodedPassword")String encodedPassword);

	public String getEncryptedPassword(String userId);

	public int changeUserPw(@Param("userId")String userId, @Param("encodedNewPassword")String encodedNewPassword);


}
