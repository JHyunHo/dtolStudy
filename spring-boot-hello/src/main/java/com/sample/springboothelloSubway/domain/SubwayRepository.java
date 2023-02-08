package com.sample.springboothelloSubway.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubwayRepository extends JpaRepository<Subway, Long> {
	List<Subway> findAll();
}
