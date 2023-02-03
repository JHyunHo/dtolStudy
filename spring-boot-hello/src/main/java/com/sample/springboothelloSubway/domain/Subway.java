package com.sample.springboothelloSubway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subway {
	private String USE_DT;
	private String LINE_NUM;
	private String SUB_STA_NM;
	private int RIDE_PASGR_NUM;
	private int ALIGHT_PASGR_NUM;
	private String WORK_DT;
}
