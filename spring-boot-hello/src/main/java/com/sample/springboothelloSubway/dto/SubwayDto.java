package com.sample.springboothelloSubway.dto;

import lombok.Data;

import javax.persistence.Table;

import com.sample.springboothelloSubway.domain.Subway;




@Data
public class SubwayDto {
	 public SubwayDto() {
	}
	private String USE_DT;
	private String LINE_NUM;
	private String SUB_STA_NM;
	private String RIDE_PASGR_NUM;
	private String ALIGHT_PASGR_NUM;
	private String WORK_DT;
	
	
	public Subway toEntity() {
		return Subway.builder()
				.USE_DT(USE_DT)
				.LINE_NUM(LINE_NUM)
				.SUB_STA_NM(SUB_STA_NM)
				.RIDE_PASGR_NUM(RIDE_PASGR_NUM)
				.ALIGHT_PASGR_NUM(ALIGHT_PASGR_NUM)
				.WORK_DT(WORK_DT)
				.build();
	}
}
