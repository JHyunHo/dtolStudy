package com.sample.springboothelloSubway.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import com.opencsv.CSVReader;
import com.sample.springboothelloSubway.dto.SubwayDto;

public class CSVParser {

    private final EntityManager em;
    boolean isDuplicate = false;

    public CSVParser(EntityManager em) {
        this.em = em;
    }


    public void read() {

        //csv파일의 절대경로 구하기
//    	C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello
        String path = System.getProperty("user.dir");   //csv파일 path 저장
        System.out.println("path = " + path);

        //저장했던 Park 객체를 저장하는 리스트 ( 중복 검사에 사용 )
        ArrayList<SubwayDto> subwayList = new ArrayList<>();

        String[] subwayInfo;

        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(path + "\\src\\main\\resources\\csv\\Subway.csv"), "EUC-KR"));
            csvReader.readNext(); // 컬럼명은 저장되지 않도록 한 줄 읽기

                //파일에서 데이터를 읽어 파싱하고 Subway 객체로 만들어 ArrayList 에 넣는다.
            	subwayInfo = csvReader.readNext();    //한 라인 읽기 (자동으로 콤마 분리해서 배열에 저장 됌)

                if (subwayInfo != null) {
                        //SubwayDto 객체 생성하기
                	SubwayDto subwayDto = new SubwayDto();
                	subwayDto.setUSE_DT(subwayInfo[0]);
                	subwayDto.setLINE_NUM(subwayInfo[1]);
                	subwayDto.setSUB_STA_NM(subwayInfo[2]);
                	subwayDto.setRIDE_PASGR_NUM(subwayInfo[3]);
                	subwayDto.setALIGHT_PASGR_NUM(subwayInfo[4]);
                	subwayDto.setWORK_DT(subwayInfo[5]);
                        

                        subwayList.add(subwayDto);   //리스트에 Park 객체 저장하기
                        em.persist(subwayDto);   //park 객체를 DB에 INSERT
                        
                }
         }catch (Exception e) {
			// TODO: handle exception
		}
        
        return ; 
        
     }
}
    


