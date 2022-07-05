package com.spring.core.chap02;

import com.spring.core.chap02.config.HotelConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class HotelTest {

    // 스프링 컨테이너에서 빈 가져오기
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HotelConfig.class);

    @Test
    @DisplayName("스프링 컨테이너에 등록된 빈들의 의존관계가 잘 결합됐다.")
    void beanTest(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
    }

    @Test
    @DisplayName("등록된 빈의 타입으로 빈을 가져와야 한다.")
    void findBeanType(){
        Chef chef = ac.getBean(Chef.class);
        chef.cook();

        // 나는 chef의 실제 인스턴스가 KimuraChef일 거라고 단언한다.
//        assertInstanceOf(KimChef.class, chef);  > 실패
        assertInstanceOf(KimuraChef.class, chef);
    }

    @Test
    @DisplayName("등록된 빈의 이름으로 빈을 가져와야 한다.")
    void findBeanTypeByName(){

        // 빈의 이름은 따로 정해놓지 않으면 등록 메서드명이 이름이 된다.
//        Restaurant restaurant = (Restaurant) ac.getBean("restaurant"); >> 이름을 지정 > 이 이름을 가진 빈 없음
        Restaurant restaurant = (Restaurant) ac.getBean("res");
        assertInstanceOf(EasternRestaurant.class, restaurant);
    }

    @Test
    @DisplayName("빈의 타입이 중복이면 예외가 발생한다.")
    void duplicateType(){
//        Course course = ac.getBean(Course.class);  // NoUniqueBeanDefinitionException
        // 예외 발생 테스트
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(Course.class);
        });
    }

    @Test
    @DisplayName("등록된 빈의 타입이 중복이면 빈의 이름과 타입으로 조회하면 된다.")
    void findBeanByduplicateType() {
        Course course = ac.getBean("sc", Course.class);
        course.combineMenu();
        assertInstanceOf(SushiCourse.class, course);
    }

    @Test
    @DisplayName("스프링 컨테이너에 등록된 모든 빈들을 출력해야 한다. ")
    void findAllBeans() {
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();  // 스프링이 등록한 모든 빈 보기

        System.out.println("======================================");
        for (String beanName : BeanDefinitionNames) {
            // 등록된 빈의 메타데이터 가져오기
            BeanDefinition bd = ac.getBeanDefinition(beanName);

            // ROLE_APPLICATION : 사용자가 직접 등록한 빈
            // ROLE_INFRASTRUCTURE : 스프링이 자체적으로 등록해서 사용하는 빈

            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println(beanName);
            }
        }
        System.out.println("======================================");
    }

}
