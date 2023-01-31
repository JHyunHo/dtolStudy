package com.sample.springboothelloSubstationInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
	
	@Value("${spring.resources.location}")
    private String resourceLocation;
	@PersistenceContext
	private final EntityManager em;
	
	
    @PostMapping("/list")
    @Autowired
    public ResponseEntity<String> fileList(){
    	String fileLocation = resourceLocation + "/init/Subway.csv";
    	Path path = Paths.get(fileLocation);
    	URI uri = path.toUri();
    	
    	try {
    		BufferedReader br = new BufferedReader(new InputStreamReader(
    				new UrlResource(uri).getInputStream()));
    		
    			String line = br.readLine();
    			while ((line = br.readLine()) != null) {
        			String[] splits = line.split(",");
        			em.persist(new SubstationInfo(splits[0], splits[1], splits[2], splits[4], Integer.parseInt(splits[5]), Integer.parseInt(splits[6]), splits[7]));
    		}
    	}catch (Exception e) {
			e.printStackTrace();
    	}
		return ResponseEntity.ok("초기화에 성공했습니다.");
    }
}
