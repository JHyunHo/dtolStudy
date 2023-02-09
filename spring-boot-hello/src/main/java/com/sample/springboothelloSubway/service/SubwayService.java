package com.sample.springboothelloSubway.service;

import org.springframework.stereotype.Service;
import com.sample.springboothelloSubway.config.CSVParser;


@Service
public class SubwayService {
	

	public void saveData(String file) {
	CSVParser parser = new CSVParser();
	parser.test(file);
	}
}
