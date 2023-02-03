package com.sample.springboothelloSubway.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext<T> {
    Parser<T> parser;

    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
    }
    public List<T> readByLine(String filename) throws IOException {
    	File csv = new File("C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello\\storage\\init\\Subway.csv");
        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(csv)
        );
        String str;
        while ((str = reader.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            }catch(Exception e){
                System.out.printf("파싱 중 문제가 생겨 이 라인은 넘어갑니다. 파일내용 : %s\n", str.substring(0, 20));
            }
        }
        reader.close();
        return result;
    }

}