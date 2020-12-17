package zzs4Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @program: dataStur
 * @description: 学习tree原理
 * @author: zzs
 * @create: 2020-07-08 10:11
 **/
public class Tree implements Runnable {


    //  private static volatile int a = 0;

    static AtomicInteger a = new AtomicInteger();

    private static int b = 0;

    public static void main(String[] args) {


   //     Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            new Thread(new Tree()).start();
           /* threads[i] = new Thread(
                    () -> {
                        for (int j = 0; j < 10; j++) {
                            // this.inc(a);
                            System.out.println(Thread.currentThread().getName() + "}" + (b++));
                            //    inc(a);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );
            threads[i].start();*/
        }

        /*int i = 0;
        System.out.println(i);

        LongAdder longAdder = new LongAdder();

        int[] ints = new int[1];
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        ThreadLocal threadLocal = new ThreadLocal();

        TreeMap<String, Object> objectObjectTreeMap = new TreeMap<>();
        objectObjectTreeMap.put("3","3");
        objectObjectTreeMap.put("2","5");

      //  TreeSet<Object> objects = new TreeSet<>();

        ArrayList<Student> objects = new ArrayList<>();
        objects.add(new Student(3));
        objects.add(new Student(4));
        objects.add(new Student(2));
        objects.add(new Student(8));

       // objects.sort(new StudentComparator());
        Collections.sort(objects,new StudentComparator());

        System.out.println(objectObjectTreeMap);
        System.out.println(objects);*/
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 10; j++) {
                // this.inc(a);
                if (b == 5){
                    System.out.println("最先计算出5的线程为："+Thread.currentThread().getName());
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "}" + (b++));
                //    inc(a);
               /* try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
}