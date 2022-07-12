# 2강 스프링컨테이너와 스프링 빈
## 스프링 컨테이너 (= DI 컨테이너)
- 스프링은 의존성 주입(DI)이라는 개념을 통해 OCP와 DIP를 가능하도록 지원한다
- 스프링 컨테이너는 의존성 주입을 위해 생성해야 할 객체들을 생성하고 관리하는 저장소 개념

### 의존성 주입 - DI(Dependency Injection)
- 제어의 역전 원칙을 구현하는 방법, 의존관계를 구현한다
- 외부에서 객체 생성의 권한을 가지고 객체를 외부에서 생성하여 필요한 클래스에 주입해주는 방식
- 의존성 주입을 사용하면 클라이언트의 코드 변경 없이도 클라이언트가 호출하는 대상의 인스턴스를 쉽게 변경할 수 있다

### 제어의 역전 - IoC(Inversion of Control)
- 객체 생성을 다른 클래스에게 위임하여 객체 생성의 제어권을 넘기는 것
 + 기존 프로그램 : 클래스 내부에서 자신이 필요한 다른 클래스의 객체를 직접 생성하여 연결, 실행함
 + 스프링 프레임워크 : 객체 생성의 제어권을 스프링 컨테이너가 전담함
- 때문에 스프링을 IoC Framework라고 부르기도 함

-----------------------------------------------------------------------
# 스프링 빈 등록, 의존관계 설정, 조회
## 1. 등록
### computer.config.ComputerConfig 
 - 스프링 컨테이너에 스프링 빈을 등록하는 설정 파일
### @Configuration
 - public class ComputerConfig 윗줄
### @Bean(name = "lMou")
 - 생성자 윗줄
 - 빈의 이름은 따로 정해놓지 않으면 등록 메서드명이 이름이 된다.

## 2. 의존성 주입(의존 관계 설정)
### 생성자 주입(constructor injection)
- 객체 생성 후 생성자에 인자로 넣기
- 객체 불변성, 안정성을 위해서는 생성자 주입이 권장됨
 + 객체 생성 후 프로그램 작동 시에 객체의 불변성을 붙이려면 필드에 final, 생성자 주입 하기
```@Bean
   public Computer computer(){
            return new Computer(samsungKeyboard(), logitecMouse(), samsungMonitor());
    }
```
### 수정자 주입(setter injection) 
- 해당 클래스에 기본생성자, 세터, 게터 만들고
 + 기본 생성자로 생성 후 세터로 주입
- 객체 생성 후에도 세터로 수정이 가능해 객체가 불안정해짐
``` @Bean
    public Restaurant restaurant(){
        EasternRestaurant er = new EasternRestaurant();
        er.setChef(chef());
        er.setCourse(sushiCourse());
        return er;
    }
```
### 의존관계 중첩
``` @Bean
    public Hotel hotel(){ return new Hotel(restaurant(), chef()); }
```

## 3. 스프링 빈 조회하기
### AnnotationConfigApplicationContext
- ApplicationContext를 스프링 컨테이너라 함.
 + 엄밀히 말하면 BeanFactory가 스프링 컨테이너 역할을 하지만 너무 추상적인 인터페이스임
- 스프링 컨테이너를 구성할 때는 구성 정보를알려줘야함. (HotelContainer.class)
```
    AnnotationConfigApplicationContext ac
        = new AnnotationConfigApplicationContext(ComputerConfig.class);
    Chef chef = ac.getBean(Chef.class);
    Restaurant restaurant = (Restaurant) ac.getBean("res");
    Course course = ac.getBean("sc", Course.class);
```
-----------------------------------------------------------------------

# xml로 빈 등록 설정하기(스프링 레거시)
1. src.main.resources에 HotelConfig.xml 파일 생성
2. 맨 윗줄에 아래 넣기
 - spring xml bean configuration로 검색
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans> <!-- 문서 끝에 빈 태그 닫기-->
```
3. HotelConfig의 @Bean → <bean> 태그
``` xml
<!-- id = "빈 이름"  class = "생성할.객체의.풀.패키지.경로" -->
<bean id="c" class="com.spring.core.chap02.JuanChef" />
``` 
4. setter 주입 → <property> 태그
```xml
    <bean id="res" class="com.spring.core.chap02.WesternRestaurant">
        <!-- name = "필드명" ref = "참조할 빈의 아이디"  -->
        <property name="chef" ref="c" />
        <property name="course" ref="fc" />
    </bean>
```
5. 생성자 주입 → <constructor-arg> 태그 
```xml
    <bean id="hotel" class="com.spring.core.chap02.Hotel">
        <!-- name = "생성자 매개변수명" ref = "주입할 빈의 아이디"   -->
        <constructor-arg name="restaurant" ref="res" />
        <constructor-arg name="headChef" ref="c" />
    </bean>
``` 