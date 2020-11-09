package com.tedu.spinLock;

import java.util.concurrent.atomic.AtomicReference;

public class SimpleSpinLock {

    /**
     * 持有锁的线程，null表示锁未被线程持有
     */
    private static AtomicReference<Thread> ref = new AtomicReference<Thread>();

    public static void lock(){
        Thread currentThread = Thread.currentThread();
        while(!ref.compareAndSet(null, currentThread)){
            //当ref为null的时候compareAndSet返回true，反之为false
            //通过循环不断的自旋判断锁是否被其他线程持有
        }
    }

    public static void unLock() {
        Thread cur = Thread.currentThread();
        if(ref.get() != cur){
            //exception ...
        }
        ref.set(null);
    }




}
