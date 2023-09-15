package com.back.contents.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieCommentDto {
	private int movieCommentNo;
	private String movieId;
	private String movieSeq;
	private String commentDetail;
	private Boolean spoilerStatus;
	private String userId;
	private String userName;
	private String userProfileImage;
	

}
