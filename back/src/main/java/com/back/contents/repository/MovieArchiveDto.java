package com.back.contents.repository;

import java.time.LocalDate;

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
public class MovieArchiveDto {
   private int movieArchiveNo;
   private String movieId;
   private String movieSeq;
   private String title;
   private String titleOrg;
   private String userId;
   private LocalDate addDate;

}
