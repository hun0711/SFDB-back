package com.back.movie.repository;

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
public class OttExistanceDto {
	private String movieSeq;
	private Boolean netflix;
	private Boolean watcha;
	private Boolean wavve;
	private Boolean tving;
	private Boolean disneyplus;
	private Boolean appletv;
	private String title;
	

}
