package com.sample.springboothelloSubway.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sample.springboothelloSubway.dao.ChartData;


@Mapper
public interface ChartMapper {
	@Select("SELECT * FROM substationinfo")
	@Results(id="SubwayMap", value={
		@Result(property = "SUB_STA_NM", column = "SUB_STA_NM"),
		@Result(property = "RIDE_PASGR_NUM", column = "RIDE_PASGR_NUM"),
		@Result(property = "ALIGHT_PASGR_NUM", column = "ALIGHT_PASGR_NUM")
	})
	List<ChartData> getChartData();
}

