package com.sample.springboothelloSubway.controller;








import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sample.springboothelloSubway.vo.SubwayInfoVo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;




@RestController
@RequestMapping
public class SubwayController {
	
	
	@PostMapping("/save")
	public SubwayInfoVo postMethod(@RequestBody SubwayInfoVo subwayInfoVo) {
		System.out.println(subwayInfoVo.toString());
		
		return subwayInfoVo;
	}
		
	

}
