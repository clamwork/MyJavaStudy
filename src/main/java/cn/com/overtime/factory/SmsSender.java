package cn.com.overtime.factory;

/**
 * @author Chengw
 * @since 2017/5/7 14:29.
 */
public class SmsSender implements Sender{

    public void send(){
        System.out.println("this is smssender");
    }
}
