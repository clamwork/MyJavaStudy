package cn.com.overtime.builder;

/**
 * 建造者模式
 * @author Chengw
 * @since 2017/5/7 15:15.
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(2);
        builder.produceSmsSender(1);
        builder.produceMailSender(2);
        builder.print();
    }
}
