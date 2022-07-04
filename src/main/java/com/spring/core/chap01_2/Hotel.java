package com.spring.core.chap01_2;

public class Hotel {

    // Hotel은 구현체인 EasternRestaurant과 KimChef에 의존 > 다형성에 제약
    // private EasternRestaurant restaurant;
    // private KimChef headChef;

    private Restaurant restaurant;
    private Chef headChef;


    // 호텔에서 객체 생성X, 이미 만들어진 객체를 끼우는 것
    // 객체가 바뀌더라고 호텔의 코드를 바꿀 필요 없음
    public Hotel(Restaurant restaurant, Chef headChef){
        this.restaurant = restaurant;
        this.headChef = headChef;
    }


    public void inform(){
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());
        restaurant.reserve();
    }


}
