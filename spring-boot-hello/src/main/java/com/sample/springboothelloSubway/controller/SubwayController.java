package com.sample.springboothelloSubway.controller;




import java.io.File;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.multipart.MultipartFile;

import com.sample.springboothelloSubway.dao.SubwayDao;


@Controller
@RequestMapping("/save")
public class SubwayController {
	private final String uploadDir = "C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello\\storage\\init\\";
	
	@PostMapping()
    public String form(@RequestPart ("file") MultipartFile file)  {
            
		String filename = file.getOriginalFilename();
        long filesize = file.getSize();
            
        System.out.println( filename);
        System.out.println( filesize);

        String fullPath = uploadDir + filename;
        
                
        try {
        	file.transferTo(new File(fullPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
      
            
        return "success";
	}	
	
	SubwayDao subwayDao;
    public SubwayController(SubwayDao subwayDao){
    		this.subwayDao = subwayDao;
    	} 

}
