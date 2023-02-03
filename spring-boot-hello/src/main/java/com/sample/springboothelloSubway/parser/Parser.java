package com.sample.springboothelloSubway.parser;

public interface Parser<T> {
    T parse(String str);
    
}
