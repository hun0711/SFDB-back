package com.back.contents.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.contents.repository.MovieCommentDto;
import com.back.contents.service.MovieCommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/contents")
@RequiredArgsConstructor
@Slf4j
public class MovieCommentController {
	private final MovieCommentService movieCommentService;
	
	/******** 코멘트 조회 ********/
	@GetMapping("/movieDetail/getMovieComment")
	public List<MovieCommentDto> getMovieComment(MovieCommentDto mcDto){
		log.info("MovieCommentController : getMovieComment 호출");
		List<MovieCommentDto> mcList = movieCommentService.getMovieComment(mcDto);
		return mcList; 
	}
	
	/******** 유저 코멘트 조회 ********/
	@GetMapping("/movieDetail/getUserMovieComment")
	public List<MovieCommentDto> getUserMovieComment(MovieCommentDto mcDto){
		log.info("MovieCommentController : getUserMovieComment 호출");
		List<MovieCommentDto> mcList = movieCommentService.getUserMovieComment(mcDto);
		return mcList; 
	}
	
	
	
	
	/******** 코멘트 등록 ********/
	@PostMapping("/movieDetail/insertMovieComment")
	public int insertMovieComment(@RequestBody MovieCommentDto mcDto){
		log.info("MovieCommentController : insertMovieComment 호출");
		int result = movieCommentService.insertMovieComment(mcDto);
		return result; 
	}
	
	/******** 코멘트 수정 ********/
	@PostMapping("/movieDetail/updateMovieComment")
	public int updateMovieComment(@RequestBody MovieCommentDto mcDto){
		log.info("MovieCommentController : updateMovieComment 호출");
		int result = movieCommentService.updateMovieComment(mcDto);
		return result; 
	}
	
	/******** 코멘트 삭제 ********/
	@PostMapping("/movieDetail/deleteMovieComment")
	public int deleteMovieComment(@RequestBody MovieCommentDto mcDto){
		log.info("MovieCommentController : deleteMovieComment 호출");
		int result = movieCommentService.deleteMovieComment(mcDto);
		return result; 
	}
}
	