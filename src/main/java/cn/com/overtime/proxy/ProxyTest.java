package cn.com.overtime.proxy;

/**
 * @author Chengw
 * @since 2017/5/7 15:51.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }

}
