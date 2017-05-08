package cn.com.overtime.abstractFactory;

import cn.com.overtime.factory.MailSender;
import cn.com.overtime.factory.Sender;

/**
 * @author Chengw
 * @since 2017/5/7 14:52.
 */
public class SendMailFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
