package com.sample.springboothelloSubway.parser;

import com.sample.springboothelloSubway.domain.Subway;

public class SubwayParser implements Parser<Subway>{
	@Override
    public Subway parse(String str) {
        String[] splitted = str.split("\",\"");
        Subway subway = new Subway();
        subway.setUSE_DT(splitted[0]);
        subway.setLINE_NUM(splitted[1]);
        subway.setSUB_STA_NM(splitted[2]);
        subway.setRIDE_PASGR_NUM(Integer.parseInt(splitted[3]));
        subway.setALIGHT_PASGR_NUM(Integer.parseInt(splitted[4]));
        subway.setWORK_DT(splitted[5]);
        return subway;
    }
}
