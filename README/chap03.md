# 자동 빈 등록, 생성
## config.ComputerAutoConfig
@Configuration
@ComponentScan(basePackages = "com.spring.core.chap03.computer")

## public class Compuer
@Component
public class Computer

## 등록할 빈 클래스(하나일 경우)
@Component
public class AppleMouse implements Mouse
@Component
public class HpKeyboard implements Keyboard
@Component
public class LgMonitor implements Monitor

## 등록할 빈 클래스(복수일 경우)
@Component("aMou"")
public class AppleMouse implements Mouse
