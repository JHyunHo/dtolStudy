package com.sample.springboothelloSubway.controller;




import java.io.File;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.sample.springboothelloSubway.service.SubwayService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SubwayController {


//    private final String uploadDir = "C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello\\src\\main\\resources\\csv\\";
//	
//    @RequestMapping(value="/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void test(MultipartHttpServletRequest req) throws Exception{
//		
//	      
//	      MultipartFile file = req.getFile("file");
//	      String file1 = file.getOriginalFilename();
//	      
//	     
//	      System.out.println(file);
//	      System.out.println(file1);
//	      String fullPath = uploadDir + file1;
//	      
//	      try {
//	        	file.transferTo(new File(fullPath));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//	        
//	        return;
//	      
//	}
    
	 private final SubwayService subwayService;
		@PostMapping("/save")
	    public void SubwayDataSave() {
	    	subwayService.saveData();
	    }

   
    
}









//@PostMapping("/save")
//public String form(@ModelAttribute ("file") MultipartFile file)  {
//        
//	String filename = file.getOriginalFilename();
//    long filesize = file.getSize();
//        
//    System.out.println( filename);
//    System.out.println( filesize);
//
//    
//    
//    System.out.println("qwe"+fullPath);
//            
//    try {
//    	file.transferTo(new File(fullPath));
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//    
//    return "success";
//}	
