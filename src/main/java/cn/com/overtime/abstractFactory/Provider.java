package cn.com.overtime.abstractFactory;

import cn.com.overtime.factory.Sender;

/**
 * 抽象工厂类接口
 * @author Chengw
 * @since 2017/5/7 14:50.
 */
public interface Provider {

    public Sender produce();

}
