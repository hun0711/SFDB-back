package com.back.contents.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.contents.repository.MovieCommentDto;
@Service
public interface MovieCommentService {

	List<MovieCommentDto> getMovieComment(MovieCommentDto mcDto);

	int insertMovieComment(MovieCommentDto mcDto);

	int updateMovieComment(MovieCommentDto mcDto);

	int deleteMovieComment(MovieCommentDto mcDto);

	List<MovieCommentDto> getUserMovieComment(MovieCommentDto mcDto);

}
