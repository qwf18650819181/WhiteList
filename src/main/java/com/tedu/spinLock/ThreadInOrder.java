package com.tedu.spinLock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 线程顺序执行
 */
public class ThreadInOrder {
    private Lock lock =new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    int count = 10;

    int flag = 0;
    public void addOne (){
        lock.lock();
        try {
            while ((flag % 3) ==2 || (flag % 3) ==0) {
                condition1.await();
            }

            if (count <= 50){
                count += 1;
                System.out.println("addOne" + count);
            }

            ++flag;
            condition2.signal();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void addTwo(){

        lock.lock();
        try {
            while ((flag % 3) ==0 || (flag % 3) ==1) {
                condition2.await();
            }

            if (count <= 50){
                count += 2;
                System.out.println("addTwo" + count);
            }

            ++flag;
            condition3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void addThree(){
        lock.lock();
        try {
            while ((flag % 3) ==1 || (flag % 3) ==2) {
                condition3.await();
            }

            if (count <= 50){
                count += 3;
                System.out.println("addThree" + count);
            }

            ++flag;
            condition1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    @Test
    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 50){
                    addOne();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 50) {
                    addTwo();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 50) {
                    addThree();
                }
            }
        }).start();

    }
}
