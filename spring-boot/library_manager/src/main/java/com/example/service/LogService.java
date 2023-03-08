package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.entity.Log;
import com.example.repository.LogRepository;


@Service
public class LogService {
	private final LogRepository logRepository;

	@Autowired
	public LogService(LogRepository logRepository) {
		this.logRepository = logRepository;
	}

	public Log insert(Library library, String returnDueDate) {
		Log log = new Log();
		log.setLibraryId(library.getId());
		log.setUserId(library.getUserId());

		log.setRentDate(LocalDateTime.now());
		log.setReturnDueDate(LocalDateTime.parse(returnDueDate + "T00:00:00"));
		log.setReturnDate(null);
		return this.save(log);
	}

	public Log save(Log log) {
		return this.logRepository.save(log);
	}

	public Log returnUpdate(Integer userId, Integer libraryId) {
		Log log = this.logRepository.findByLibraryIdAndUserIdOrderByRentDateDesc(libraryId, userId).get(0);
		log.setReturnDate(LocalDateTime.now());
		return this.save(log);
	}


	public List<Log> findByUserId(Integer userId){
		return this.logRepository.findByUserIdOrderByRentDateAsc(userId);
	}


}