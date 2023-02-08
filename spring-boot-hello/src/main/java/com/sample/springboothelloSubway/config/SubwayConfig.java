package com.sample.springboothelloSubway.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.springboothelloSubway.repository.JpaSubwayRepository;
import com.sample.springboothelloSubway.repository.SubwayRepository;



@Configuration
public class SubwayConfig {
	private EntityManager em;
	private DataSource dataSource;
		
	@Autowired
	public SubwayConfig(DataSource dataSource, EntityManager em) {
		this.dataSource = dataSource;
		this.em = em;
	}
	
	@Bean
	public SubwayRepository subwayRepository() {
		return new JpaSubwayRepository(em);
	}

//	@Bean
//	public SubwayService subwayService() {
//		return new SubwayService(subwayRepository());
//	}
}
