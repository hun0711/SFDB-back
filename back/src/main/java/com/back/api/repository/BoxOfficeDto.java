package com.back.api.repository;

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
public class BoxOfficeDto {
	    private int boxofficeRank; // UK - 박스오피스랭킹
	    private String movieId; //고유코드
	    private String movieSeq; //고유코드
	    private String title; // 제목
	    private String titleOrg; // 원제
	    private String prodYear; // 제작연도
	    private String nation; // 국가
	    private String runtime; // 상영시간
	    private String rating; // 등급
	    private String repRlsDate; // 개봉일
	    private String directorIds; //감독 아이디
	    private String directorNms; //감독 이름
	    private String actorNms; // 배우 정보 (id가 존재하지 않는 배우도 있으므로 이름으로 대체)
	    private String plotText; //줄거리
	    private String keywords; //키워드
	    private String poster; //포스터
	    private String awards1; //수상 내역
	    private String salesShare; //예매율
	    private String audiAcc; //누적관객수
	
}
