package cn.com.overtime.decorator;

/**
 * 装饰器模式测试
 * @author Chengw
 * @since 2017/5/7 15:46.
 */
public class DecoratorTest {
  
    public static void main(String[] args) {  
        Sourceable source = new Source();  
        Sourceable obj = new Decorator(source);  
        obj.method();  
    }  
}  