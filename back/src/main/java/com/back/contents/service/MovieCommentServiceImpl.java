package com.back.contents.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.contents.repository.MovieCommentDao;
import com.back.contents.repository.MovieCommentDto;
import com.back.movie.repository.MovieDao;
import com.back.movie.service.MovieServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class MovieCommentServiceImpl implements MovieCommentService{
     private final MovieCommentDao movieCommentDao;
	
	@Override
	public List<MovieCommentDto> getMovieComment(MovieCommentDto mcDto) {
		log.info("MovieCommentServiceImpl : getMovieComment 호출");
		List<MovieCommentDto> mcList = movieCommentDao.getMovieComment(mcDto);
		return mcList;
	}


	
	@Override
	public List<MovieCommentDto> getUserMovieComment(MovieCommentDto mcDto) {
		log.info("MovieCommentServiceImpl : getUserMovieComment 호출");
		List<MovieCommentDto> mcList = movieCommentDao.getUserMovieComment(mcDto);
		return mcList;
	}

	
	@Override
	public int insertMovieComment(MovieCommentDto mcDto) {
		log.info("MovieCommentServiceImpl : insertMovieComment 호출");
		int result = movieCommentDao.insertMovieComment(mcDto);
		return result;
	}

	@Override
	public int updateMovieComment(MovieCommentDto mcDto) {
		log.info("MovieCommentServiceImpl : updateMovieComment 호출");
		int result = movieCommentDao.updateMovieComment(mcDto);
		return result;
	}

	@Override
	public int deleteMovieComment(MovieCommentDto mcDto) {
		log.info("MovieCommentServiceImpl : deleteMovieComment 호출");
		int result = movieCommentDao.deleteMovieComment(mcDto);
		return result;
	}


}
