package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log,Integer>{
	public Log findByLibraryId(Integer libraryId);
	public List<Log> findByUserIdOrderByRentDateAsc(Integer userId);
	public List<Log> findByLibraryIdAndUserIdOrderByRentDateDesc(Integer libraryId, Integer userId);
}
