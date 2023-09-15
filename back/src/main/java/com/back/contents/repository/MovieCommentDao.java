package com.back.contents.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieCommentDao {

	List<MovieCommentDto> getMovieComment(MovieCommentDto mcDto);

	int insertMovieComment(MovieCommentDto mcDto);

	int updateMovieComment(MovieCommentDto mcDto);

	int deleteMovieComment(MovieCommentDto mcDto);

	List<MovieCommentDto> getUserMovieComment(MovieCommentDto mcDto);

}
