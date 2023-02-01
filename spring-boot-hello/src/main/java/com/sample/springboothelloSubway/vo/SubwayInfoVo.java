package com.sample.springboothelloSubway.vo;




import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Substationinfo")
@NoArgsConstructor
public class SubwayInfoVo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private String id;
   @Column(name = "USE_DT")
   private String USE_DT;
   @Column(name = "LINE_NUM")
   private String LINE_NUM;
   @Column(name = "SUB_STA_NM")
   private String SUB_STA_NM;
   @Column(name = "RIDE_PASGR_NUM")
   private double RIDE_PASGR_NUM;
   @Column(name = "ALIGHT_PASGR_NUM")
   private double ALIGHT_PASGR_NUM;
   @Column(name = "WORK_DT")
   private String WORK_DT;

   public SubwayInfoVo(String id, String USE_DT, String LINE_NUM, 
   String SUB_STA_NM, double RIDE_PASGR_NUM, double ALIGHT_PASGR_NUM, 
   String WORK_DT) {
       this.id = id;
       this.USE_DT = USE_DT;
       this.LINE_NUM = LINE_NUM;
       this.SUB_STA_NM = SUB_STA_NM;
       this.RIDE_PASGR_NUM = RIDE_PASGR_NUM;
       this.ALIGHT_PASGR_NUM = ALIGHT_PASGR_NUM;
       this.WORK_DT = WORK_DT;
   }
   @Override
   public String toString() {
	   
	return "OK";
	   
   }
}