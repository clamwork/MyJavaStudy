package cn.com.overtime.Mediator;

/**
 * 中介者模式测试
 */
public class Test {
  
    public static void main(String[] args) {  
        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();  
    }  
}