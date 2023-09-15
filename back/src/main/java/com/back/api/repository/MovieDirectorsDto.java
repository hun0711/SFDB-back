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
public class MovieDirectorsDto {

	private int movieDirectorsNo;
	private String directorNm;
    private String directorEnNm;
    private String directorId;
    private String imageUrl;
}
