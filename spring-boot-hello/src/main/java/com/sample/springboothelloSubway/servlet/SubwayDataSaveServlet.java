package com.sample.springboothelloSubway.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.springboothelloSubway.service.SubwayService;


@WebServlet(name = "subwayDataSaveServlet", urlPatterns = "/save")
public class SubwayDataSaveServlet extends HttpServlet {
	
	@Autowired
	private  SubwayService subwayService;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException{
		subwayService.saveData();
	}
	
}
