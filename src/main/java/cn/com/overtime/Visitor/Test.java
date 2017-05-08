package cn.com.overtime.Visitor;

/**
 * 访问者模式测试
 */
public class Test {
  
    public static void main(String[] args) {  
          
        Visitor visitor = new MyVisitor();  
        Subject sub = new MySubject();  
        sub.accept(visitor);      
    }  
} 