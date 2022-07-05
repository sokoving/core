package com.spring.core.chap03;

import org.springframework.stereotype.Component;

@Component("kc")
public class KimuraChef implements Chef {
    @Override
    public void cook() {
        System.out.println("일식의 대가 키무라입니다. ");
    }
}
