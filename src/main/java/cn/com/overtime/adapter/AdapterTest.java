package cn.com.overtime.adapter;

/**
 * 适配器模式的测试
 * @author Chengw
 * @since 2017/5/7 15:34.
 */
public class AdapterTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 类的适配器模式测试
     */
    public static void test1(){
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

    /**
     * 对象的适配器模式测试
     */
    public static void test2(){
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }

    /**
     * 接口的适配器模式测试
     */
    public static void test3(){
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();

        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}
