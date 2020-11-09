package com.tedu.spinLock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class SpiningLockTest {


    @Test
    public void test1(){
        String initialReference = " 原来的 ";

        AtomicReference<String> atomicStringReference =
                new AtomicReference<String>(initialReference);

        String newReference = " 后来的 ";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("改变后: " + exchanged+"  "+ atomicStringReference.get());

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("改变后: " + exchanged+"  "+ atomicStringReference.get());

        exchanged = atomicStringReference.compareAndSet(newReference, initialReference);
        System.out.println("改变后: " + exchanged+"  "+ atomicStringReference.get());
    }

    int count = 0;
    CountDownLatch countDownLatch = new CountDownLatch(100);
    @Test
    public void test()throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < 100 ; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    SimpleSpinLock.lock();
                    ++count;
                    SimpleSpinLock.unLock();
                    countDownLatch.countDown();
                }
            });

        }
        countDownLatch.await();
        System.out.println(count);
    }


    @Test
    public void testPri()throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < 100 ; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    ++count;
                    countDownLatch.countDown();
                }
            });

        }
        countDownLatch.await();
        System.out.println(count);
    }


}
