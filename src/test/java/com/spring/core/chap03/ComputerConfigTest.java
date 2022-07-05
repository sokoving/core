package com.spring.core.chap03;

import com.spring.core.chap03.computer.Computer;
import com.spring.core.chap03.computer.config.ComputerAutoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerConfigTest {

    @Test
    void ComputerAutoConfigTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComputerAutoConfig.class);
        ac.getBean(Computer.class).showSpec();
    }
}
