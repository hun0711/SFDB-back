package com.back.movie.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.back.api.repository.BoxOfficeDto;
import com.back.api.repository.MovieActorsDto;
import com.back.api.repository.MovieDirectorsDto;
import com.back.api.repository.MovieDto;
import com.back.api.repository.RecommendMovieDto;
import com.back.api.repository.ReleaseSoonMovieDto;
import com.back.api.repository.Top20SfMovieDto;

@Mapper
public interface MovieDao {

	//영화 조회 (Top 20 , 추천)
	List<MovieDto> movieList();

	//영화 정보 조건 검색 (top20 , 추천)
	List<MovieDto> selectMovie(MovieDto mDto);

	//영화 정보 상세보기
	List<MovieDto> movieDetail(MovieDto mDto);

	//TOP 20 영화
	List<Top20SfMovieDto> top20SfMovie();

    //추천 영화
	List<RecommendMovieDto> recommendMovie();

	
	//박스오피스 순위
	List<BoxOfficeDto> todayBoxofficeRank();

	//박스오피스 상세보기
	List<BoxOfficeDto> boxofficeDetail(BoxOfficeDto boDto);
	
	//개봉 예정 영화
	List<ReleaseSoonMovieDto> releaseSoonMovie();

	
	//ott유무
	List<OttExistanceDto> ottExistance(OttExistanceDto oDto);

	
	//감독 정보
	List<MovieDirectorsDto> directorsInfo(MovieDirectorsDto mdDto);

	
	//배우 정보
	List<MovieActorsDto> actorsInfo(MovieActorsDto maDto);

	//감독 이미지
	List<MovieDirectorsDto> directorImage(MovieDirectorsDto mdDto);

	//배우 이미지
	List<MovieActorsDto> actorImage(MovieActorsDto maDto);



}
