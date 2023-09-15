package com.back.movie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.api.repository.BoxOfficeDto;
import com.back.api.repository.MovieActorsDto;
import com.back.api.repository.MovieDirectorsDto;
import com.back.api.repository.MovieDto;
import com.back.api.repository.RecommendMovieDto;
import com.back.api.repository.ReleaseSoonMovieDto;
import com.back.api.repository.Top20SfMovieDto;
import com.back.movie.repository.OttExistanceDto;
import com.back.movie.service.MovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/movie")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
	private final MovieService movieService;
	
	/******** 영화 정보 전체조회 (top20 , 추천) ********/
	@GetMapping("/movieList")
	public List<MovieDto> movieList(){
		log.info("MovieController : movieList 호출");
		List<MovieDto> mList = movieService.movieList();
		return mList; 
	}
	
	/******** 영화 정보 조건검색 (top20 , 추천) ********/
    @GetMapping("/selectMovie")
    public List<MovieDto> selectMovie(MovieDto mDto) {
    	log.info("MovieController : selectMovie 호출");
        List<MovieDto> selectMovie = movieService.selectMovie(mDto);
        return selectMovie;
    }

    /******** 영화 정보 상세보기 ********/
    @GetMapping("/movieDetail")
    public List<MovieDto> movieDetail(MovieDto mDto) {
    	log.info("MovieController : movieDetail 호출");
        List<MovieDto> movieDetail = movieService.movieDetail(mDto);
        return movieDetail;
    }
    
    
    
    /******** Top 20 영화  ********/
    @GetMapping("/top20SfMovie")
    public List<Top20SfMovieDto> top20SfMovie() {
    	log.info("MovieController : top20SfMovie 호출");
        List<Top20SfMovieDto> top20SfMovie = movieService.top20SfMovie();
        return top20SfMovie;
    }
    
    
    /*********** 추천 영화 ***********/
    @GetMapping("/recommendMovie")
    public List<RecommendMovieDto> recommendMovie() {
    	log.info("MovieController : RecommendMovie호출");
        List<RecommendMovieDto> recommendMovie = movieService.recommendMovie();
        return recommendMovie;
    }
    
    

    /********* 박스오피스 순위 ***************/
    @GetMapping("/todayBoxofficeRank")
    public List<BoxOfficeDto> todayBoxofficeRank() {
    	log.info("MovieController : TodayBoxofficeRank호출");
        List<BoxOfficeDto> todayBoxofficeRank = movieService.todayBoxofficeRank();
        return todayBoxofficeRank;
    }
    
    /******** 박스오피스 영화 상세보기 ********/
    @GetMapping("/boxofficeDetail")
    public List<BoxOfficeDto> movieDetail(BoxOfficeDto boDto) {
    	log.info("MovieController : boxofficeDetail 호출");
    	List<BoxOfficeDto> boxofficeDetail = movieService.boxofficeDetail(boDto);
    	return boxofficeDetail;
    }
    
    /********** 개봉 예정 영화 ********/
    @GetMapping("/releaseSoonMovie")
    public List<ReleaseSoonMovieDto> releaseSoonMovie() {
    	log.info("MovieController : ReleaseSoonMovie호출");
        List<ReleaseSoonMovieDto> releaseSoonMovie = movieService.releaseSoonMovie();
        return releaseSoonMovie;
    }


    
    /******** OTT 정보 **********/
    @GetMapping("/ottExistance")
     public List<OttExistanceDto> ottExistance(OttExistanceDto oDto) {
     log.info("MovieController : OttExistance 호출");
     List<OttExistanceDto> ottExistance = movieService.ottExistance(oDto);
     return ottExistance;
    }

    
    /******* 감독 정보 ***********/
    @GetMapping("/directorsInfo")
    public List<MovieDirectorsDto> directorsInfo(MovieDirectorsDto mdDto) {
        log.info("MovieController : directorsInfo 호출");
        List<MovieDirectorsDto> directorsInfo = movieService.directorsInfo(mdDto);
        return directorsInfo;
       }
    
    
    /******* 배우 정보 ***********/
    @GetMapping("/actorsInfo")
    public List<MovieActorsDto> actorsInfo(MovieActorsDto maDto) {
        log.info("MovieController : actorsInfo 호출");
        List<MovieActorsDto> actorsInfo = movieService.actorsInfo(maDto);
        return actorsInfo;
       }

    /******* 감독 정보 ***********/
    @GetMapping("/directorImage")
    public List<MovieDirectorsDto> directorImage(MovieDirectorsDto mdDto) {
        log.info("MovieController : directorImage 호출");
        List<MovieDirectorsDto> directorImage = movieService.directorImage(mdDto);
        return directorImage;
       }
    
    
    @GetMapping("/actorImage")
    public List<MovieActorsDto> actorImage(MovieActorsDto maDto) {
        log.info("MovieController : actorImage 호출");
        List<MovieActorsDto> actorImage = movieService.actorImage(maDto);
        return actorImage;
       }
    
    
}
