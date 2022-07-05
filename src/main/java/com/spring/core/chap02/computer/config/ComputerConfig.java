package com.spring.core.chap02.computer.config;

import com.spring.core.chap02.computer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 스프링 빈을 등록하는 설정 파일
@Configuration
public class ComputerConfig {

    @Bean(name = "lMou")
    public Mouse logitecMouse(){return new LogitecMouse();}
    @Bean(name = "aMou")
    public Mouse appleMouse(){return new AppleMouse();}

    @Bean(name = "sMon")
    public Monitor samsungMonitor(){return new SamsungMonitor();}
    @Bean(name = "lMon")
    public Monitor lgMonitor(){return new LgMonitor();}

    @Bean(name = "sKey")
    public Keyboard samsungKeyboard(){return new SamsungKeyboard();}
    @Bean(name = "hKey")
    public Keyboard HpKeyboard(){return new HpKeyboard();}

    @Bean(name = "com")
    public Computer computer(){
        return new Computer(samsungKeyboard(), logitecMouse(), samsungMonitor());
    }


}
