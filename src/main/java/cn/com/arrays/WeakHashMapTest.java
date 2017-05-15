package cn.com.arrays;

import java.util.*;

/**
 * WeakHashMap 特点是当初了自身有对key的引用外，如果此key没有其他引用，那么此Map会自动丢弃该值。
 * 代码中声明了两个map对象，一个是HashMap对象，一个是weakHashMap，同事向两个map中放入A，B两个对象，
 * 当HashMap删除A，并且A,B都只想NULL时，WeakHashMap 中的A奖自动被回收掉。
 * 对于A对象而言，当HashMap删除并且将A指向null后，除了WeakHashMap 中还保存A外已经没有指向A的指针了，所以WeakHashMap会自动舍弃掉a。
 * 而对于B对象虽然指向了null，但HashMap 中还有指向B的指针所以WeakHashMap将会保留B对象。
 * @author Chengw
 * @since 2017/5/15 14:36.
 */
public class WeakHashMapTest {

    public static void main(String[] args) throws Exception{
        String a = new String("a");
        String b = new String("b");
        Map weakmap = new WeakHashMap();
        Map map = new HashMap();
        map.put(a,"aaa");
        map.put(b,"bbbb");
        weakmap.put(a,"aaa");
        weakmap.put(b,"bbbb");
        map.remove(a);
        a = null;
        b = null;
        System.gc();
        Iterator i = map.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry en = (Map.Entry)i.next();
            System.out.println("map:" + en.getKey() + " : "+ en.getValue());
        }

        Iterator j = map.entrySet().iterator();
        while(j.hasNext()){
            Map.Entry en = (Map.Entry)j.next();
            System.out.println("weakmap:" + en.getKey() + " : "+ en.getValue());
        }


        /**
         * WeakHashMap 主要是通过expungeStaleEntries 这个函数来实现移除其内部不用的条目，从而达到自动释放内存的目的。
         * 基本上只要对WeakHashMap 的内容进行访问就会调用这个函数，从而达到清楚其内部不在为外部引用的条目。
         * 但是如果预先生成了WeakHashMap，而在GC以前又不曾访问该WeakHashMap.那不是就不能释放内存了。
         * 以下代码 在java 默认内存为64M的情况下运行，会出现内存溢出的错误。（因此调大了矩阵块的比例）
         * 由此说明了在不访问WeakHashMap的情况下，WeakHashMap的内存还是不会被释放的。
         * WeakHashMap 实现弱引用，是因为它的Entry<K,V>是继承了WeakReference<K>的。
         */
        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
        for (int m = 0; m < 1000; m++) {
            WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
//            d.put(new byte[1000][1000], new byte[1000][1000]);
            d.put(new byte[10000][10000], new byte[10000][10000]);
            maps.add(d);
            System.gc();
            System.err.println(m);

            /**
             * 此处对WeakHashMap的访问，在下列代码之后，内存得到释放。
             * 注释以下代码后运行，会看到内存溢出的错误。
             * Size方法调用了expungeStaleEntries方法，该方法对JVM要回收的Entry(Quene 中)进行了遍历，并将Entry的Value置空，回收了内存。
             * 所以效果是Key在gc的时候被清除，Value 在key清除后访问WeakHashMap 被清除。
             */
            for(int n = 0;n < m; n++){
                System.err.println(n  + " size:" + maps.get(m).size());
            }

        }




    }

}
