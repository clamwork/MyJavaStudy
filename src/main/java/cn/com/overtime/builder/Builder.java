package cn.com.overtime.builder;

import cn.com.overtime.factory.MailSender;
import cn.com.overtime.factory.Sender;
import cn.com.overtime.factory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * @author Chengw
 * @since 2017/5/7 15:12.
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }

    public void print(){
        for(Sender sender:list){
            sender.send();
        }
    }
}
