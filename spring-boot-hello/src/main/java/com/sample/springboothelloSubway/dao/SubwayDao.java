package com.sample.springboothelloSubway.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sample.springboothelloSubway.domain.Subway;

import javax.persistence.Table;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
@Slf4j
@Table(name= "substationinfo")
public class SubwayDao {
	private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    RowMapper<Subway> rowMapper=new RowMapper<Subway>() {
        @Override
        public Subway mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Subway subway=new Subway(
                    rs.getString("USE_DT"),
                    rs.getString("LINE_NUM"), 
                    rs.getString("SUB_STA_NM"),
                    rs.getInt("RIDE_PASGR_NUM"),
                    rs.getInt("ALIGHT_PASGR_NUM"),
                    rs.getString("WORK_DT"));
            
                    return subway;
        }
    };

    public SubwayDao(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.dataSource=dataSource;
        this.jdbcTemplate=jdbcTemplate;
    }

    //INSERT INTO `substationinfo`
    // (`USE_DT`, `LINE_NUM`, `SUB_STA_NM`, `RIDE_PASGR_NUM`, `ALIGHT_PASGR_NUM`, `WORK_DT`) VALUES
    // ('20230122', '8호선', '가락시장', '1639', '1767', '20230125');

    public void add(final Subway subway){
        String sql = "Insert into substationinfo values " +
                "(?, ?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(sql, subway.getUSE_DT(),
        		subway.getLINE_NUM(), subway.getSUB_STA_NM(),
        		subway.getRIDE_PASGR_NUM(), subway.getALIGHT_PASGR_NUM(), subway.getWORK_DT());
    }
    
    

}
