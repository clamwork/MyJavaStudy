package cn.com.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Vertor 类似于ArrayList，区别是Vector是线程同步的。
 * 在多线程中，vector的操作不会
 *
 * @author Chengw
 * @since 2017/5/15 15:36.
 */
public class VectorTest {

    static int maxSize = 100000;

    static Vector vector = new Vector();

    static ArrayList list = new ArrayList();

    static class VectorEdit implements Runnable {
        private Vector sub;

        private String name;

        public VectorEdit(Vector v, String name) {
            this.sub = v;
            this.name = name;
        }

        public void run() {
            while (true) {
                vector.remove(0);
            }
        }
    }

    static class VectorRun implements Runnable {

        private Vector sub;

        private String name;

        public VectorRun(Vector v, String name) {
            this.sub = v;
            this.name = name;
        }

        public void run() {
            int num = 0;
            while (true) {
                if (sub.size() <= maxSize) {
                    sub.add(name + " ：" + num++);
                    System.out.println(name + " size :" + vector.size());
                }
            }
//            System.out.println(name +"' vector size :" + vector.size());
        }
    }

    static class ArrayListEdit implements Runnable {

        private ArrayList sub;

        private String name;

        public ArrayListEdit(ArrayList list, String name) {
            this.sub = list;
            this.name = name;
        }

        public void run() {
            int num = 0;
            while (true) {
                list.remove(0);
            }
//            System.out.println(name +"' arrayList size :" + list.size());
        }
    }

    static class ArrayListRun implements Runnable {

        private ArrayList sub;

        private String name;

        public ArrayListRun(ArrayList list, String name) {
            this.sub = list;
            this.name = name;
        }

        public void run() {
            int num = 0;
            while (true) {
                if (sub.size() <= maxSize) {
                    sub.add(name + " ：" + num++);
                    System.out.println(name + " array size :" + sub.size());
                }

//
            }
//            System.out.println(name +"' arrayList size :" + list.size());
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es1 = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.execute(new VectorRun(vector, "vector thread  " + i));
            es.execute(new VectorEdit(vector, "vector edit thread  " + i));
            es1.execute(new ArrayListRun(list,"arrayList thread  " + i));
            es2.execute(new ArrayListEdit(list,"arrayList edit thread  " +i ));
        }



        /*while (true) {
            Iterator iterator = vector.iterator();
            if (vector.size() >= maxSize) {
                System.out.println("vector total size :" + vector.size());
                break;
            }

        }
        while (true) {
            Iterator iterator = vector.iterator();
            if (list.size() >= maxSize) {
                System.out.println("arrayList total size :" + list.size());
                break;
            }

        }*/
    }
}
