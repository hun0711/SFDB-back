package com.back.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.back.api.repository.MovieActorsDto;
import com.back.api.repository.MovieDirectorsDto;

@Service
public interface ApiService {

	void saveMoviesFromApi();

	void todayBoxofficeFromApi();
	
	void updateBoxofficeFromApi();

	void recommendMovies();

	void releaseSoonMovies();

	void saveDirectorImages();

	void saveActorImages();


}
