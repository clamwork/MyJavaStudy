package cn.com.overtime.decorator;

/**
 * 装饰器模式
 * 对原对象进行装饰
 * @author Chengw
 * @since 2017/5/7 15:46.
 */
public class Decorator implements Sourceable{

    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
