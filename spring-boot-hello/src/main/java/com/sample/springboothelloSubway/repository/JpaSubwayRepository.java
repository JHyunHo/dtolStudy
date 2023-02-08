package com.sample.springboothelloSubway.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sample.springboothelloSubway.dto.SubwayDto;

@Repository
@Transactional
@Component
public class JpaSubwayRepository implements SubwayRepository{
	
	private final EntityManager em;
	boolean isDuplicate = false;
	
	@Autowired
	public JpaSubwayRepository(EntityManager em) {
		this.em =em;
	}
	@Override
	public void save() {
		
		Query q = em.createQuery("DELETE FROM substationinfo");  //SubwayDto Data 초기화
		q.executeUpdate();
		
//		C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello\\
		String path = System.getProperty("user.dir");
		System.out.println("path =" +path);
		
		//중복검사에 사용
		ArrayList<SubwayDto> subwayList = new ArrayList<>();
		
		FileReader in = null;
		BufferedReader bufIn = null;
		
		try {
			in = new FileReader(path + "\\src\\main\\resources\\csv\\Subway.csv");
			bufIn = new BufferedReader(in);
			bufIn.readLine(); // 한줄읽기
			
			String data;
			
			do{
				data = bufIn.readLine();
			
			if(data != null) {
				String[] SubwayInfo = data.split(","); // ","(콤마)로 분리하기
				SubwayDto subwayDto = new SubwayDto(); // Subway 객체 생성
				
				if(data !=null){
					// 객체에 값 저장하기
					subwayDto.setUSE_DT(SubwayInfo[0].isEmpty() ? "" : SubwayInfo[0]); 
					subwayDto.setLINE_NUM(SubwayInfo[1].isEmpty() ? "" : SubwayInfo[1]);
					subwayDto.setSUB_STA_NM(SubwayInfo[2].isEmpty() ? "" : SubwayInfo[2]);
					subwayDto.setRIDE_PASGR_NUM(SubwayInfo[3].isEmpty() ?  ""  : SubwayInfo[3]);
					subwayDto.setALIGHT_PASGR_NUM(SubwayInfo[4].isEmpty() ?  ""  : SubwayInfo[4]);
					subwayDto.setWORK_DT(SubwayInfo[5].isEmpty() ?  ""  : SubwayInfo[5]);
					
					em.persist(subwayDto); // DB에 컬럼별로 split하여 추출한 데이터 저장
				}			
			}
		}while(data != null);
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}finally {
		try {
			in.close();
		}catch (Exception e) {
			// TODO: handle exception
		}try {
			bufIn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}		
}
}
