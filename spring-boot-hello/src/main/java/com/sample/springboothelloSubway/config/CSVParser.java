package com.sample.springboothelloSubway.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import java.sql.*;


public class CSVParser{
	public void test(String file){
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&serverTimezone=UTC&characterEncoding=EUC-KR", "root", "dtol0330");
		      PreparedStatement pstmt = connection.prepareStatement(
		          "INSERT IGNORE INTO substationinfo (USE_DT, LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM, WORK_DT) VALUES (?, ?, ?, ?, ?, ?)");
		  	  String path = "C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello\\src\\main\\resources\\csv\\" + file;
		      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "EUC-KR"));
//		      FileWriter writer = new FileWriter(file);
//		      SVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT
//                      .withHeader("Index", "Column1", "Column2", "Column3"));
		      String line;
		      while ((line = br.readLine()) != null) {
		        String[] data = line.split(",");
		        pstmt.setString(1, data[0]);
		        pstmt.setString(2, data[1]);
		        pstmt.setString(3, data[2]);
		        pstmt.setString(4, data[3]);
		        pstmt.setString(5, data[4]);
		        pstmt.setString(6, data[5]);
		        pstmt.executeUpdate();
		      }
		      br.close();
		      connection.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
}

    


