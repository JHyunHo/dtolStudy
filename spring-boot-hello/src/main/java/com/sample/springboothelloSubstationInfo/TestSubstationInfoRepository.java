package com.sample.springboothelloSubstationInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;

import com.mysql.cj.Query;

@Transactional
@Component
public class TestSubstationInfoRepository implements SubstationInfoRepository {
	private EntityManager em;
	
	@Autowired
	public TestSubstationInfoRepository(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void save() {
		Query q = (Query) em.createQuery("DELETE FROM SubstationInfo");
		((javax.persistence.Query) q).executeUpdate();
		
		String path = System.getProperty("C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello");
		FileReader in = null;
		BufferedReader bufIn = null;
		try {
			in = new FileReader(path + "/src/main/resources/csv/Subway.csv");
			bufIn = new BufferedReader(in);
			bufIn.readLine();
			
			String data;
			do {
				data = bufIn.readLine();
				if(data !=null) {
					String[] subwayinfo = data.split(",");
					SubstationInfo  substationinfo = new SubstationInfo(data, data, data, data, 0, 0, data);
					
					if (data !=null) {
						substationinfo.setId(subwayinfo[0].isEmpty() ? "" : subwayinfo[0]);
						
						em.persist(substationinfo);
					}
							
				}
			}
			
		}
		
		
	}

	
}
