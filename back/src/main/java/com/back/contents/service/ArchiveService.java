package com.back.contents.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.contents.repository.MovieArchiveDto;

@Service
public interface ArchiveService {

	List<MovieArchiveDto> checkMovieArchive(MovieArchiveDto maDto);

	List<MovieArchiveDto> getUserArchive(MovieArchiveDto maDto);

	int addToArchive(MovieArchiveDto maDto);

	int deleteToArchive(MovieArchiveDto maDto);

}
