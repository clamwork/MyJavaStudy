package cn.com.overtime.facade;

/**
 * 外观模式
 * @author Chengw
 * @since 2017/5/7 15:58.
 */
public class User {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }

}
