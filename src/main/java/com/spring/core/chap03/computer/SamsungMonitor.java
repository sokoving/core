package com.spring.core.chap03.computer;

public class SamsungMonitor implements Monitor {
    @Override
    public void info() {
        System.out.println("삼성 모니터입니다.");
    }
}
