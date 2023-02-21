package com.sample.springboothelloSubway.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sample.springboothelloSubway.dao.SubwayDao;

@Mapper
public interface SubwayMapper {
	@Select("SELECT LINE_NUM,SUB_STA_NM FROM substationinfo")
	@Results(id="SubwayMap", value={
//		@Result(property = "USE_DT", column = "USE_DT"),
		@Result(property = "LINE_NUM", column = "LINE_NUM"),
		@Result(property = "SUB_STA_NM", column = "SUB_STA_NM")
//		@Result(property = "RIDE_PASGR_NUM", column = "RIDE_PASGR_NUM"),
//		@Result(property = "ALIGHT_PASGR_NUM", column = "ALIGHT_PASGR_NUM"),
//		@Result(property = "WORK_DT", column = "WORK_DT")
	})
	List<SubwayDao> getAll();
}

//	@Select("SELECT * FROM substationinfo WHERE LINE_NUM = #{LINE_NUM}")
//		SubwayDao findByLINE_NUM(String LINE_NUM);
//}
