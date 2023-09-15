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
public class MovieActorsDto {
	
	private int movieActorsNo;
	private String actorNm;
	private String actorEnNm;
	private String actorId;
	private String imageUrl;

}
