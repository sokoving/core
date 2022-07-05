package com.spring.core.chap02;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class WesternRestaurant implements Restaurant {

    // 특정 셰프가 아닌 역할에 의존(Chef나 Course를 임플리먼트한 클래스라면 어떤 것이든 세프와 코스가 될 수있다
    private Chef chef;
    private Course course;


    public WesternRestaurant(Chef chef, Course course) {
        this.chef = chef;
        this.course = course;
    }

    @Override
    public void reserve() {
        course.combineMenu();
    }

    @Override
    public void order() {
        chef.cook();
    }
}

