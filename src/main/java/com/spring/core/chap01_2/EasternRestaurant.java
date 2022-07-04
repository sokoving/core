package com.spring.core.chap01_2;

public class EasternRestaurant implements Restaurant {

    // 특정 셰프가 아닌 역할에 의존
    private Chef chef;
    private Course course;


    public EasternRestaurant(Chef chef, Course course) {
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
