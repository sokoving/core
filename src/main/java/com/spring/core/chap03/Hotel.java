package com.spring.core.chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 클래스 호텔을 컨테이너에 자동 등록
public class Hotel {

    private final Restaurant restaurant; // 필드에 final 후 생성자 주입하면 필드 변경 불가
    private final Chef headChef;

    // 생성자 주입 사용시 생성자가 딱 한개면 @Autowired없이도 자동으로 생성자 주입을 수행
    @Autowired // 자동 의존성 주입
    public Hotel( @Qualifier("easternRestaurant")
                  Restaurant restaurant, @Qualifier("kc") Chef headChef) {
        System.out.println("\n\n\nHotel 생성자 호출!\n\n\n");
        this.restaurant = restaurant;
        this.headChef = headChef;
    }


    public void inform(){
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());
        restaurant.reserve();
    }


}
