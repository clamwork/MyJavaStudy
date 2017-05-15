package cn.com.arrays;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap 则提供了一种完全不同的Map实现。
 * 从功能上讲，TreeMap有着比 HasHMap 更为强大的功能，它实现了SortMap接口，这意味着它可以对元素进行排序。
 * TreeMap的性能略微低于HashMap.
 * 使用TreeMap的迭代输出将会以元素顺序进行。 LinkedHashMap 是基于元素进入集合的顺序或者被访问的选后顺序排序，treeMap 则基于元素的固有顺序
 * (Comparator 或者 Comparable) 确定顺序
 * LinkedHashMap 是根据元素增加 或者访问的先后顺序进行排序，而TreeMap 则根据元素的key 进行排序
 * @author Chengw
 * @since 2017/5/15 11:02.
 */
public class TreeMapTest {

    static class Student implements Comparable<Student>{

        private String name;
        private int score;

        public Student(String name,int score){
            this.name = name;
            this.score = score;
        }

        public int compareTo(Student o) {
            if(o.score < this.score){
                return 1;
            }else if(o.score > this.score){
                return -1;
            }else{
               return o.name.compareTo(this.name);
            }
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("name :" +this.name);
            sb.append(" score :" +this.score);
            return sb.toString();
        }

        StudentDetailInfo getStudentDetailInfo(){
           return new StudentDetailInfo(this);
        }

        class StudentDetailInfo{
            Student s;

            public StudentDetailInfo(Student s){
                this.s = s;
            }

            @Override
            public String toString() {
                return s.name +"'s detail information";
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TreeMap map = new TreeMap();
        Student s1 = new Student("1",100);
        Student s2 = new Student("2",97);
        Student s3 = new Student("3",90);
        Student s4 = new Student("4",93);
        Student s5 = new Student("6",95);
        Student s6 = new Student("5",91);
        Student s7 = new Student("8",93);
        Student s8 = new Student("7",93);
        map.put(s1,s1.getStudentDetailInfo());
        map.put(s2,s2.getStudentDetailInfo());
        map.put(s3,s3.getStudentDetailInfo());
        map.put(s4,s4.getStudentDetailInfo());
        map.put(s5,s5.getStudentDetailInfo());
        map.put(s6,s6.getStudentDetailInfo());
        map.put(s7,s7.getStudentDetailInfo());
        map.put(s8,s8.getStudentDetailInfo());

        //打印分数位于 s7 和 s2 之间的人
        Map submap = map.subMap(s7,s2);
        for(Iterator iterator = submap.keySet().iterator();iterator.hasNext();){
            Student key = (Student) iterator.next();
            System.out.println(key +" -> "+ map.get(key));
        }
        System.out.println("subMap end");

        //打印分数比 s2 低的人
        submap = map.headMap(s2);
        for(Iterator iterator = submap.keySet().iterator();iterator.hasNext();){
            Student key = (Student) iterator.next();
            System.out.println(key +" -> "+ map.get(key));
        }
        System.out.println("subMap end");

        //打印分数比 s4 高的人
        submap = map.tailMap(s4);
        for(Iterator iterator = submap.keySet().iterator();iterator.hasNext();){
            Student key = (Student) iterator.next();
            System.out.println(key +" -> "+ map.get(key));
        }
        System.out.println("subMap end");
    }
}
