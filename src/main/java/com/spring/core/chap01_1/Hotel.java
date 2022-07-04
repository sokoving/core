package com.spring.core.chap01_1;

public class Hotel {

    // Hotel은 구현체인 EasternRestaurant과 KimChef에 의존 > 다형성에 제약
    // private EasternRestaurant restaurant;
    // private KimChef headChef;

    private Restaurant restaurant;
    private Chef headChef;


    // SOLD 원칙 위배
    // SRP : 호텔이 식당와 헤드셰프 객체를 생성하면 안 됨
    //      호텔의 식당과 혜드셰프를 바꾸려면 여러 클래스를 다 바꿔야 함
    // OCP : 호텔의 레스토랑와 헤드셰프 확장에는 열려 있지만
    //      변경하려면 코드를 변경해야 가능하지 변경에 닫혀 있지 않다
    public Hotel(){
        this.restaurant = new EasternRestaurant();
        this.headChef = new KimuraChef();
    }


    public void inform(){
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());
        restaurant.reserve();
    }


}
