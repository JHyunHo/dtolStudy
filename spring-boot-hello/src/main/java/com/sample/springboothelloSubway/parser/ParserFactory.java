package com.sample.springboothelloSubway.parser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.springboothelloSubway.domain.Subway;

@Configuration
public class ParserFactory {
    @Bean
    public ReadLineContext<Subway> subwayReadLineContextest(){
        return new ReadLineContext<Subway>(new SubwayParser());
    }
}