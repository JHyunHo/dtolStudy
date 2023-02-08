package com.sample.springboothelloSubway.service;



import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sample.springboothelloSubway.config.CSVParser;
import com.sample.springboothelloSubway.repository.SubwayRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
@Transactional
@Component
public class SubwayService{
	private final EntityManager em;
	
	@Autowired
	private final SubwayRepository subwayRepository;
	
	public void saveData() {
		
		
		
		
		//data 초기화
		em.createQuery("DELETE FROM substationinfo").executeUpdate();
	
		
		CSVParser parser = new CSVParser(em);
		parser.read();
		
	}
	
}
