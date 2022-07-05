package com.spring.core.chap03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor @Getter // 세터 자동주입을 하려면 롬복으로 @Setter 하면 안 됨
public class EasternRestaurant implements Restaurant {

    private Chef chef;
    private Course course;


    public EasternRestaurant(Chef chef, Course course) {
        System.out.println("\n\n\nEastern 생성자 호출!\n\n\n");
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


    // 수정자 주입
    @Autowired
    @Qualifier("kc") // chef가 복수이기 때문에 대상 명시
    public void setChef(Chef chef) {
        System.out.println("\n\n\nEastern setChef 호출!\n\n\n");
        this.chef = chef;
    }
    @Autowired
    public void setCourse(Course course) {
        System.out.println("\n\n\nEastern setCourse 호출!\n\n\n");
        this.course = course;
    }
}
