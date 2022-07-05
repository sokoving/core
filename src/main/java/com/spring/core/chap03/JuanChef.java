package com.spring.core.chap03;

import org.springframework.stereotype.Component;

@Component("jc")
public class JuanChef implements Chef {
    @Override
    public void cook() {
        System.out.println("양식의 대가 후안입니다. ");
    }
}
