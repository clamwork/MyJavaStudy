package cn.com.overtime.abstractFactory;

import cn.com.overtime.factory.Sender;
import cn.com.overtime.factory.SmsSender;

/**
 * @author Chengw
 * @since 2017/5/7 14:52.
 */
public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
