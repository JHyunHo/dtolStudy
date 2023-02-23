package com.sample.springboothelloSubway.controller;




import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sample.springboothelloSubway.dao.ChartData;
import com.sample.springboothelloSubway.dao.SubwayDao;
import com.sample.springboothelloSubway.mapper.SubwayMapper;
import com.sample.springboothelloSubway.service.SubwayService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SubwayController {
	private final SubwayService subwayService;
    private final String uploadDir = "C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello\\src\\main\\resources\\csv\\";
	
    @PostMapping("/save")
	@ResponseBody
	public String test(MultipartHttpServletRequest req) throws Exception{
	
	      MultipartFile file = req.getFile("file");
	      String file1 = file.getOriginalFilename();
	   
	      System.out.println(file);
	      System.out.println(file1);
	      String fullPath = uploadDir + file1;
	      
	      try {
	        	file.transferTo(new File(fullPath));
			} catch (Exception e) {
				e.printStackTrace();
			}      
	       subwayService.saveData(file1);
	        return "success";
	} 
    
	@GetMapping("/subway")   
	public List<SubwayDao> getSubway(){
		return subwayService.getSubway();
	}
	
	@GetMapping("/chart")   
	public List<ChartData> getChartData(){
		return subwayService.getChartData();
	} 
	
}










