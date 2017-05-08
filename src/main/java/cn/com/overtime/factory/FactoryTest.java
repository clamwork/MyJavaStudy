package cn.com.overtime.factory;

/**
 * @author Chengw
 * @since 2017/5/7 14:33.
 */
public class FactoryTest {

    public static void main(String[] args){
        test1();
        test2();
        test3();
    }

    /**
     * 单一工厂方法模式
     */
    public static void test1(){
        SendFactory factory = new SendFactory();
        Sender  sender = factory.produce("sms");
        sender.send();
    }

    /**
     * 多个工厂方法模式
     */
    public static void test2(){
        SendFactory factory = new SendFactory();
        Sender  sender = factory.produceMail();
        sender.send();
    }

    /**
     * 静态工厂方法模式
     */
    public static void test3(){
        Sender sender = SendFactory.produceStaticMail();
        sender.send();
    }

}
