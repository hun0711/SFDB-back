package com.back.api.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.api.repository.MovieActorsDto;
import com.back.api.repository.MovieDirectorsDto;
import com.back.api.service.ApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ApiController {
	    private final ApiService apiService;
 
/************************ API 데이터 호출  ***********************/	    
	    //영화 정보 호출
	    @PostMapping("/movies")
	    public ResponseEntity<String> saveMoviesFromApi() {
	    	log.info("영화 api 호출");
	    	apiService.saveMoviesFromApi();
	    	return ResponseEntity.ok("Movies saved from API.");
	  }

       //일별 박스오피스 정보 호출
	    @PostMapping("/movies/todayBoxoffice")
	    public ResponseEntity<String> todayBoxofficeFromApi(){
	       log.info("오늘 박스오피스 api 호출");
	       apiService.todayBoxofficeFromApi();
	       return ResponseEntity.ok("Boxoffice saved from Api.");
	    }
	    
	    
	    //박스오피스 변경사항 업데이트
	    @PostMapping("/movies/updateBoxoffice")
	    public ResponseEntity<String> updateBoxofficeFromApi(){
	    	log.info("박스오피스 업데이트 호출");
	    	apiService.updateBoxofficeFromApi();
	    	return ResponseEntity.ok("Boxoffice updated from Api.");
	    }

       //추천 영화 정보 호출
	    @PostMapping("/movies/recommendMovies")
	    public ResponseEntity<String> recommendMovies() {
	    	log.info("추천 영화 정보 호출");
	    	apiService.recommendMovies();
	    	return ResponseEntity.ok("Recommend Movies saved from Api.");
	    }
	   
	    //개봉 예정 영화 정보 호출
	    @PostMapping("/movies/releaseSoonMovies")
	    public ResponseEntity<String> releaseSoonMovies() {
	    	log.info("추천 영화 정보 호출");
	    	apiService.releaseSoonMovies();
	    	return ResponseEntity.ok("ReleaseSoon Movies saved from Api.");
	    }
	    
	    //감독 이미지 api 저장
	    @GetMapping("/save/directorImages")
	    public ResponseEntity<String> saveDirectorImages() {
	        apiService.saveDirectorImages();
	        return ResponseEntity.ok("감독 이미지 저장");
	    }
	    
	    //배우 이미지 api 저장
	    @GetMapping("/save/actorImages")
	    public ResponseEntity<String> getActorImages() {
	    	log.info("배우 이미지 api 업로드 호출");
	    	  apiService.saveActorImages();
		      return ResponseEntity.ok("배우 이미지 저장");  		
	    }


}
