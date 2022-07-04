package com.spring.core.chap01_2.config;

import com.spring.core.chap01_2.*;

// 호텔에 필요한 객체들을 생성하고 조립하여 의존관계를 설정해주는 역할을 가진 클래스
// Bean Factory(Spring Container)
public class HotelManager {

    // 쉐프 객체를 생성하여 리턴하는 메서드
    public Chef chef() {
        return new KimuraChef();
    }
    // 코스 객체를 생성하여 리턴하는 메서드
    public Course course() {
        return new SushiCourse();
    }

    // 레스토랑 객체를 생성하여 리턴하는 메서드
    public Restaurant restaurant() {
        return new EasternRestaurant(chef(), course());
    }

    // 호텔 객체를 생성하여 리턴하는 메서드
    public Hotel hotel() {
        return new Hotel(restaurant(), chef());
    }


}
