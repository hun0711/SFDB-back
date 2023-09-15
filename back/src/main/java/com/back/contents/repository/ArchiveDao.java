package com.back.contents.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArchiveDao {

	List<MovieArchiveDto> checkMovieArchive(MovieArchiveDto maDto);

	List<MovieArchiveDto> getUserArchive(MovieArchiveDto maDto);

	int addToArchive(MovieArchiveDto maDto);

	int deleteToArchive(MovieArchiveDto maDto);

}
