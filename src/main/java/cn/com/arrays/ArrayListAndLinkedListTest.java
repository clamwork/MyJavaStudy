package cn.com.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList and LinkedList for test
 * ArrayList 的每一次有效的元素删除操作后都要进行数据的重组，并且删除的元素位置越靠前，数组重组的开销越大，要删除的元素位置越靠后，开销越小。
 * ArrayList 是基于数组实现的，而数组是一块连续的内存空间，如果在数组的任意位置插入元素，必然导致在该位置后的所有元素需要重新排列，因此其效果较差，尽可能降数据插入到尾部。
 * LinkdList 不会因为数据插入导致性能下降。
 * LinkedList  要移除中间的数据需要遍历完半个List。
 *
 * @author Chengw
 * @since 2017/5/15 09:22.
 */
public class ArrayListAndLinkedListTest {

    public static void main(String[] args) throws  Exception{

        long start = System.currentTimeMillis();
        List<Integer>  arrayList = new ArrayList<Integer>();
        for(int i = 0 ; i< 5000000;i++){
            arrayList.add(new Integer(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("arrayList add time :" +(end - start) +" ms");
        start = System.currentTimeMillis();
        List<Integer>  linkedList = new LinkedList<Integer>();
        for(int i = 0 ; i< 5000000;i++){
           linkedList.add(new Integer(i));
        }
        end = System.currentTimeMillis();
        System.out.println("linkedList add time :" +(end - start) +" ms");


        start = System.currentTimeMillis();
        for(int i = 0 ; i< 1000;i++){
            arrayList.add(0,new Integer(i));
        }
        end = System.currentTimeMillis();
        System.out.println("arrayList add top time :" +(end - start) +" ms");

        start = System.currentTimeMillis();
        for(int i = 0 ; i< 1000;i++){
            linkedList.add(0,new Integer(i));
        }
        end = System.currentTimeMillis();
        System.out.println("linkedList add top time :" +(end - start) +" ms");


        start = System.currentTimeMillis();
        arrayList.remove(0);
        end = System.currentTimeMillis();
        System.out.println("arrayList remove first opject time :" +(end - start) +" ms");

        start = System.currentTimeMillis();
        arrayList.remove(2500000);
        end = System.currentTimeMillis();
        System.out.println("arrayList remove mid opject time :" +(end - start) +" ms");

        start = System.currentTimeMillis();
        linkedList.remove(0);
        end = System.currentTimeMillis();
        System.out.println("linkedList remove first object time :" +(end - start) +" ms");

        start = System.currentTimeMillis();
        linkedList.remove(2500000);
        end = System.currentTimeMillis();
        System.out.println("linkedList remove mid object time :" +(end - start) +" ms");

        System.out.println("arrayList size :" + arrayList.size());

        System.out.println("linkedList size :" + linkedList.size());
    }
}
