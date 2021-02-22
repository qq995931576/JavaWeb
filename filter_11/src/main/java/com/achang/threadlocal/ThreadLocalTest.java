package com.achang.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/******
 @author 阿昌
 @create 2020-12-03 12:03
 *******
 */
public class ThreadLocalTest {

    //    public final static Map<String,Object> data = new Hashtable<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static class Task implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            //在run()方法中随机生成一个变量（线程要关联的数据），以当前线程名为key保存到Map中
            int i = random.nextInt(1000);//取0-999的随机数

            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程【" + name + "】生成的随机数是： " + i);
//            data.put(name,i);
            threadLocal.set(i);

            try {
                //线程睡眠5秒钟
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //在Run()方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
//            Object o = data.get(name);

            Object o = threadLocal.get();
            System.out.println("在线程【" + name + "快结束时取出关联的数据是： " + o);


        }

    }


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {

            new Thread(new Task()).start();

        }

    }


}
