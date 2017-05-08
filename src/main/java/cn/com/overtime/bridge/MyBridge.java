package cn.com.overtime.bridge;

/**
 * 桥接器模式
 */
public class MyBridge extends Bridge {
    public void method(){  
        getSource().method();  
    }  
}  