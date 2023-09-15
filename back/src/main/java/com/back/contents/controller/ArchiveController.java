package com.back.contents.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.contents.repository.MovieArchiveDto;
import com.back.contents.repository.MovieCommentDto;
import com.back.contents.service.ArchiveService;
import com.back.contents.service.MovieCommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/contents")
@RequiredArgsConstructor
@Slf4j
public class ArchiveController {
	private final ArchiveService archiveService;
	
	/******** 영화 보관함 존재 유무 ********/
	@GetMapping("/archive/checkMovieArchive")
	public List<MovieArchiveDto> checkMovieArchive(MovieArchiveDto maDto){
		log.info("ArchiveController : checkMovieArchive 호출");
		List<MovieArchiveDto> maList = archiveService.checkMovieArchive(maDto);
		return maList; 
	}
	
	/******** 유저 보관함 전체조회 ********/
	@GetMapping("/archive/getUserArchive")
	public List<MovieArchiveDto> getUserArchive(MovieArchiveDto maDto){
		log.info("ArchiveController : getUserArchive 호출");
		List<MovieArchiveDto> maList = archiveService.getUserArchive(maDto);
		return maList; 
	}
	
	/******** 보관함 추가 ********/
	@PostMapping("/archive/addToArchive")
	public int addToArchive(@RequestBody MovieArchiveDto maDto){
		log.info("ArchiveController : addToArchive 호출");
		int result = archiveService.addToArchive(maDto);
		return result; 
	}
	
	/******** 보관함 삭제 ********/
	@PostMapping("/archive/deleteToArchive")
	public int deleteToArchive(@RequestBody MovieArchiveDto maDto){
		log.info("ArchiveController : deleteToArchive 호출");
		int result = archiveService.deleteToArchive(maDto);
		return result; 
	}
	
}
