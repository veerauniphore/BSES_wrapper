package com.uniphore.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniphore.entity.ReportEntity;

public interface Report extends CrudRepository<ReportEntity, Integer> {

	
	
}
