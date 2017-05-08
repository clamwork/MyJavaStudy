package cn.com.overtime.factory;

/**
 * @author Chengw
 * @since 2017/5/7 14:31.
 */
public class SendFactory {

    /**
     * 单一工厂方法模式
     * @param type
     * @return
     */
    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new SmsSender();
        }else{
            return null;
        }
    }

    /**
     * 多个工厂方法模式
     * @return
     */
    public Sender produceSms(){
        return new SmsSender();
    }

    public Sender produceMail(){
        return new MailSender();
    }

    /**
     * 静态工厂方法模式
     * @return
     */
    public static Sender produceStaticSMS(){
        return new SmsSender();
    }

    public static Sender produceStaticMail(){
        return new MailSender();
    }
}
