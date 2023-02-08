package com.sample.springboothelloSubway.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "substationinfo")
@Entity(name = "substationinfo")
public class Subway {
	@Id
	//사용일자
	@Column(name = "USE_DT")
	private String USE_DT;
	//호선
	@Column(name = "LINE_NUM")
	private String LINE_NUM;
	//역명
	@Column(name = "SUB_STA_NM")
	private String SUB_STA_NM;
	//승차
	@Column(name = "RIDE_PASGR_NUM")
	private String RIDE_PASGR_NUM;
	//하차
	@Column(name = "ALIGHT_PASGR_NUM")
	private String ALIGHT_PASGR_NUM;
	//등록일자
	@Column(name = "WORK_DT")
	private String WORK_DT;
	
	@Builder
	public Subway(String USE_DT, String LINE_NUM,  String SUB_STA_NM,  String RIDE_PASGR_NUM,  String ALIGHT_PASGR_NUM,  String WORK_DT ) {
		this.USE_DT = USE_DT;
		this.LINE_NUM = LINE_NUM;
		this.SUB_STA_NM = SUB_STA_NM;
		this.RIDE_PASGR_NUM = RIDE_PASGR_NUM;
		this.ALIGHT_PASGR_NUM = ALIGHT_PASGR_NUM;
		this.WORK_DT = WORK_DT;
	}
}
