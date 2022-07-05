package com.spring.core.chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HotelXmlTest {

    // 스프링 컨테이너 객체 생성
    // resourceLocations : xml 파일 경로 적기(resources 패키지 기준)
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("HotelConfig.xml");

    @Test
    @DisplayName("xml 설정파일에 등록된 ")
    void findBeanTest(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
    }


}
