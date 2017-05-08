package cn.com.overtime.factory;

/**
 * @author Chengw
 * @since 2017/5/7 14:28.
 */
public class MailSender implements Sender{

    public void send(){
        System.out.println("this is mailsender");
    }
}
