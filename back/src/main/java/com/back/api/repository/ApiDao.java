package com.back.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiDao {

    //영화 정보 저장
	void save(MovieDto movieDto);


	//감독 중복 확인
	boolean existsDirectorById(String directorId);
	
	//감독 정보 저장
	void saveDirectors(MovieDirectorsDto movieDirectorsDto);

	

	//배우 중복 확인
	boolean existsActorById(String actorId);

	//배우 정보 저장
	void saveActors(MovieActorsDto movieActorsDto);


	
	
	//박스오피스 순위 저장
    void saveBoxOffice(BoxOfficeDto boxOfficeDto);

    //박스오피스 영화 중복 확인
	boolean existsBoxofficeByTitle(String title);

    //박스오피스 데이터 삭제(갱신)
	void deleteBoxofficeData();


	
	
	
	//추천 sf영화
	void saveRecommendMovie(RecommendMovieDto recommendmovieDto);
	
	//개봉 예정 sf영화
    void saveReleaseSoonMovie(ReleaseSoonMovieDto releasesoonmovieDto);


    //감독 목록
	List<MovieDirectorsDto> directorList();

    //배우 목록
	List<MovieActorsDto> actorList();

    //감독 이미지 저장
	void saveDirectorImages(@Param("directorId")String directorId,@Param("imageUrl")String imageUrl);

    //배우 이미지 저장
	void saveActorImages(@Param("actorId")String actorId,@Param("imageUrl")String imageUrl);


}
