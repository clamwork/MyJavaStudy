package cn.com.overtime.proxy;

/**
 * 代理模式
 * @author Chengw
 * @since 2017/5/7 15:50.
 */
public class Proxy implements Sourceable{

    private Source source;
    public Proxy(){
        super();
        this.source = new Source();
    }
    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }
    private void atfer() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }
}
