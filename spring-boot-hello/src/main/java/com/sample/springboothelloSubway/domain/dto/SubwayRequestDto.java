package com.sample.springboothelloSubway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubwayRequestDto {
	private String USE_DT;
	private String LINE_NUM;
	private String SUB_STA_NM;
	private int RIDE_PASGR_NUM;
	private int ALIGHT_PASGR_NUM;
	private String WORK_DT;
}
