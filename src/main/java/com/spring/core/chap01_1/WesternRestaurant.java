package com.spring.core.chap01_1;

public class WesternRestaurant implements Restaurant {

    // 특정 셰프가 아닌 역할에 의존(Chef나 Course를 임플리먼트한 클래스라면 어떤 것이든 세프와 코스가 될 수있다
    private Chef chef;
    private Course course;


    public WesternRestaurant() {
        this.chef = new JuanChef();
        this.course = new FrenchCourse();
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

