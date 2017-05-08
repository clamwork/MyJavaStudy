package cn.com.overtime.adapter;

/**
 * 对象的适配器
 * @author Chengw
 * @since 2017/5/7 15:36.
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
