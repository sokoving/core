package com.spring.core.chap02;

import com.spring.core.chap02.computer.AppleMouse;
import com.spring.core.chap02.computer.Computer;
import com.spring.core.chap02.computer.Monitor;
import com.spring.core.chap02.computer.SamsungMonitor;
import com.spring.core.chap02.computer.config.ComputerConfig;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComputerConfig.class);

    @Test
    @DisplayName("자바 클래스 설정파일에 등록한 Computer 빈을 가져와야 한다")
    void findBeanClassConfigTest(){

        Computer computer = ac.getBean(Computer.class);
        computer.showSpec();
    }


    @Test
    @DisplayName("컨테이너에서 조회한 빈은 단 하나의 객체여야 한다.")
    void singleton() {

        // Value Object(복수 인스턴스를 생성하는 클래스)는 빈 등록하면 안 된다
        // 의존성이 있는 클래스만 스프링 컨테이너에 등록해서 싱글톤으로 생성
        Monitor m1 = ac.getBean(Monitor.class);
        Monitor m2 = ac.getBean(Monitor.class);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);

        assertEquals(m1, m2);

    }

    @Test
    @DisplayName("xml 설정파일에 등록한 Computer 빈을 가져와야 한다.")
    void findBeanXMLConfigTest() {

        Computer computer = ac.getBean(Computer.class);
        computer.showSpec();
    }
}

