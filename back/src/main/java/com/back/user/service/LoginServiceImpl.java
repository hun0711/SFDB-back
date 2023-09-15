	package com.back.user.service;
	
	import java.util.List;

import org.springframework.stereotype.Service;

import com.back.api.repository.MovieDto;
import com.back.user.repository.LoginDao;
	import com.back.user.repository.UserDto;
	
	import lombok.RequiredArgsConstructor;
	import lombok.extern.slf4j.Slf4j;
	
	@Slf4j
	@Service
	@RequiredArgsConstructor
	public class LoginServiceImpl implements LoginService {
	
		private final LoginDao loginDao;
	
		//사이트 자체 회원 확인
		@Override
	    public String getEncryptedPassword(String userId) {
	        return loginDao.findEncryptedPasswordByUserId(userId); // 암호화된 비밀번호 리턴
	    }
	
		
	
		//구글 회원 확인
		@Override
		public UserDto getUserByGoogleId(String googleId) {
			log.info("구글 소셜 로그인 호출");
			// 데이터베이스에서 해당 googleId를 가진 사용자를 조회
			// 만약 사용자를 찾으면 그 사용자의 정보를 담은 USerDto 객체를 반환
			
			UserDto user = loginDao.findByGoogleId(googleId);
			if(user != null) {
				UserDto userDto = new UserDto();
				userDto.setUserId(user.getUserId());
				userDto.setUserName(user.getUserName());
				userDto.setUserEmail(user.getUserEmail());
				userDto.setUserProfileImage(user.getUserProfileImage());
			    return userDto;
			} else {
				// 해당 googleId를 가진 사용자가 존재하지 않으면 null을 반환
				return null;
			}
		}

	
		//네이버 회원 확인
		@Override
		public UserDto getUserByNaverId(String naverId) {
			log.info("네이버 소셜 로그인 호출");
			// 데이터베이스에서 해당 naverId를 가진 사용자를 조회
			// 만약 사용자를 찾으면 그 사용자의 정보를 담은 UserDto 객체를 반환
			
			UserDto user = loginDao.findByNaverId(naverId);
			if (user != null) {
				UserDto userDto = new UserDto();
				userDto.setUserId(user.getUserId());
				userDto.setUserName(user.getUserName());
				userDto.setUserEmail(user.getUserEmail());
				userDto.setUserBirth(user.getUserBirth());
				userDto.setUserProfileImage(user.getUserProfileImage());
				return userDto;
			} else {
				// 해당 naverId를 가진 사용자가 존재하지 않으면 null을 반환
				return null;
			}
		}


       //구글 회원 확인
		@Override
		public UserDto getUserByKakaoId(String kakaoId) {
           log.info("카카오 소셜 로그인 호출");
           // 데이터베이스에서 해당 kakaoId를 가진 사용자를 조회
           // 만약 사용자를 찾으면 그 사용자의 정보를 담은 UserDto 객체를 반환
           
           UserDto user = loginDao.findByKakaoId(kakaoId);
           if (user != null) {
        	   UserDto userDto = new UserDto();
        	   userDto.setUserId(user.getUserId());
        	   userDto.setUserName(user.getUserName());
        	   userDto.setUserEmail(user.getUserEmail());
        	   userDto.setUserBirth(user.getUserBirth());
        	   userDto.setUserProfileImage(user.getUserProfileImage());
               return userDto;
           }else {
        	 // 해당 kakaoId를 가진 사용자가 존재하지 않으면 null을 반환
        	 return null;
         }
		}



		@Override
		public List<UserDto> userInfo(String userId) {
			log.info("유저 정보 호출");
			List<UserDto> userInfo = loginDao.userInfo(userId);
			return userInfo; 
		}
		
	}
	
