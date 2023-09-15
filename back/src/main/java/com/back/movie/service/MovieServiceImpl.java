package com.back.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.api.repository.ApiDao;
import com.back.api.repository.BoxOfficeDto;
import com.back.api.repository.MovieActorsDto;
import com.back.api.repository.MovieDirectorsDto;
import com.back.api.repository.MovieDto;
import com.back.api.repository.RecommendMovieDto;
import com.back.api.repository.ReleaseSoonMovieDto;
import com.back.api.repository.Top20SfMovieDto;
import com.back.api.service.ApiServiceImpl;
import com.back.movie.repository.MovieDao;
import com.back.movie.repository.OttExistanceDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
     private final MovieDao movieDao;
	
   //영화 조회 (Top 20 , 추천)
	@Override
	public List<MovieDto> movieList() {
		log.info("MovieServiceImpl : movieList 호출");
		List<MovieDto> mList = movieDao.movieList();
		return null;
	}

	
	
	
	// 영화 정보 조건 검색 (top20 , 추천)
	@Override
	public List<MovieDto> selectMovie(MovieDto mDto) {
		log.info("MovieServiceImpl : selectMovie 호출");
        List<MovieDto> selectMovie = movieDao.selectMovie(mDto);
        return selectMovie;
	}

	
	
	
	//영화 정보 상세보기
	@Override
	public List<MovieDto> movieDetail(MovieDto mDto) {
		log.info("MovieServiceImpl : movieDetail 호출");
        List<MovieDto> movieDetail = movieDao.movieDetail(mDto);
        return movieDetail;
	}

	
	
	
	//TOP 20 영화
	@Override
	public List<Top20SfMovieDto> top20SfMovie() {
		log.info("MovieServiceImpl : top20SfMovie 호출");
        List<Top20SfMovieDto> top20SfMovie = movieDao.top20SfMovie();
        return top20SfMovie;
	}

	
	
	//추천 영화
	@Override
	public List<RecommendMovieDto> recommendMovie() {
		log.info("MovieServiceImpl : recommendMovie 호출");
        List<RecommendMovieDto> recommendMovie = movieDao.recommendMovie();
        return recommendMovie;
	}

	
	
	//박스오피스 순위
	@Override
	public List<BoxOfficeDto> todayBoxofficeRank() {
		log.info("MovieServiceImpl : todayBoxofficeRank 호출");
		List<BoxOfficeDto> todayBoxofficeRank = movieDao.todayBoxofficeRank();
		return todayBoxofficeRank;
	}
	
	//박스오피스 상세보기
	@Override
	public List<BoxOfficeDto> boxofficeDetail(BoxOfficeDto boDto) {
		log.info("MovieServiceImpl : boxofficeDetail 호출");
		List<BoxOfficeDto> boxofficeDetail = movieDao.boxofficeDetail(boDto);
		return boxofficeDetail;
	}
	
	//개봉 예정 영화
	@Override
	public List<ReleaseSoonMovieDto> releaseSoonMovie() {
		log.info("MovieServiceImpl : releaseSoonMovie 호출");
        List<ReleaseSoonMovieDto> releaseSoonMovie = movieDao.releaseSoonMovie();
        return releaseSoonMovie;
	
	}



    //ott유무
	@Override
	public List<OttExistanceDto> ottExistance(OttExistanceDto oDto) {
		log.info("MovieServiceImpl : ottExistence 호출");
		List<OttExistanceDto> ottExistance = movieDao.ottExistance(oDto);
		return ottExistance;
	}



   //감독정보
	@Override
	public List<MovieDirectorsDto> directorsInfo(MovieDirectorsDto mdDto) {
		log.info("MovieServiceImpl : directorInfo 호출");
		List<MovieDirectorsDto> directorsInfo = movieDao.directorsInfo(mdDto);
		return directorsInfo;
	}



   //배우정보
	@Override
	public List<MovieActorsDto> actorsInfo(MovieActorsDto maDto) {
		log.info("MovieServiceImpl : actorsInfo 호출");
		List<MovieActorsDto> actorsInfo = movieDao.actorsInfo(maDto);
		return actorsInfo;
	}



   //감독 이미지
	@Override
	public List<MovieDirectorsDto> directorImage(MovieDirectorsDto mdDto) {
		log.info("MovieServiceImpl : directorImage 호출");
		List<MovieDirectorsDto> directorImage = movieDao.directorImage(mdDto);
		return directorImage;
	}




	//배우 이미지
	@Override
	public List<MovieActorsDto> actorImage(MovieActorsDto maDto) {
		log.info("MovieServiceImpl : actorImage 호출");
		List<MovieActorsDto> actorImage = movieDao.actorImage(maDto);
		return actorImage;
	}



}
