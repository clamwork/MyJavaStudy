package cn.com.overtime.abstractFactory;

import cn.com.overtime.factory.Sender;

/**
 * 抽象工厂类的测试
 * @author Chengw
 * @since 2017/5/7 14:53.
 */
public class Test {

    public static void main(String[] args){
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
