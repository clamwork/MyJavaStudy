package cn.com.overtime.adapter;

/**
 * 类的适配器模式
 * @author Chengw
 * @since 2017/5/7 15:33.
 */
public class Adapter extends Source implements Targetable{

    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
