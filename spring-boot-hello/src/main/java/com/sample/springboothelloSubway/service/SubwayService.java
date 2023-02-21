package com.sample.springboothelloSubway.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.springboothelloSubway.config.CSVParser;
import com.sample.springboothelloSubway.dao.SubwayDao;
import com.sample.springboothelloSubway.mapper.SubwayMapper;


@Service
public class SubwayService {
	

	public void saveData(String file) {
	CSVParser parser = new CSVParser();
	parser.test(file);
	}
	
	@Autowired
    private SubwayMapper subwayMapper;

    public List<SubwayDao> getAll() {
        return subwayMapper.getAll();
    }
	
	
}
