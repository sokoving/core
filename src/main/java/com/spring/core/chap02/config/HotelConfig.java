package com.spring.core.chap02.config;

import com.spring.core.chap02.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 스프링 빈을 등록하는 설정 파일
@Configuration
public class HotelConfig {

    // 빈 등록 방식 - 생성자 주입, 세터 주입
    @Bean   // 생성을 스프링에 위임
    public Chef chef() {
        return new KimuraChef();
    }
    @Bean(name = "sc")
    public Course sushiCourse() {
        return new SushiCourse();
    }
    @Bean(name = "fc")
    public Course FrenchCourse() {
        return new FrenchCourse();
    }

    @Bean(name = "res") // 빈 이름 짓기, 안 지으면 메서드명으로 자동 설정
    public Restaurant restaurant(){
        // 생성자 주입(constructor injection)
            // 객체 생성 후 생성자에 인자로 넣기
                // > 객체 불변성, 안정성을 위해서는 생성자 주입이 권장됨
//        EasternRestaurant er = new EasternRestaurant(chef(), sushiCourse());

        // 수정자 주입(setter injection)
            // 해당 클래스에 기본생성자, 세터, 게터 만든 후
            // 기본 생성자로 생성 > 세터로 주입
                // > 객체 생성 후 세터로 수정이 가능해 객체가 불안정해짐
        EasternRestaurant er = new EasternRestaurant();
        er.setChef(chef());
        er.setCourse(sushiCourse());
        return er;
    }

    @Bean
    public Hotel hotel(){
        return new Hotel(restaurant(), chef());
    }

}
