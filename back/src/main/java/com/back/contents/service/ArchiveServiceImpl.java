package com.back.contents.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.contents.repository.ArchiveDao;
import com.back.contents.repository.MovieArchiveDto;
import com.back.contents.repository.MovieCommentDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArchiveServiceImpl implements ArchiveService{
	private final ArchiveDao archiveDao;

	//유저 보관함 존재유무
	@Override
	public List<MovieArchiveDto> checkMovieArchive(MovieArchiveDto maDto) {
		log.info("ArchiveServiceImpl : checkMovieArchive 호출");
		List<MovieArchiveDto> maList = archiveDao.checkMovieArchive(maDto);
		return maList;
	}

	//유저 보관함 전체조회
	@Override
	public List<MovieArchiveDto> getUserArchive(MovieArchiveDto maDto) {
		log.info("ArchiveServiceImpl : getUserArchive 호출");
		List<MovieArchiveDto> maList = archiveDao.getUserArchive(maDto);
		return maList;
	}

	//보관함 추가
	@Override
	public int addToArchive(MovieArchiveDto maDto) {
		log.info("ArchiveServiceImpl : addToArchive 호출");
		int result = archiveDao.addToArchive(maDto);
		return result;
	}

	//보관함 삭제
	@Override
	public int deleteToArchive(MovieArchiveDto maDto) {
		log.info("ArchiveServiceImpl : deleteToArchive 호출");
		int result = archiveDao.deleteToArchive(maDto);
		return result;
	}

}
