package com.mikasa.springboot.example.runner;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sherlock on 2016/11/14.
 */
public class TTLthreadTest {

    static TransmittableThreadLocal<String> parent = new TransmittableThreadLocal<String>();

    public static void main(String[] args) throws Exception {

        parent.set("value-set-in-parent");

        Runnable task = new Task("task-1");
        // 额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(ttlRunnable);

// =====================================================

        // Task中可以读取, 值是"value-set-in-parent"
        String value = parent.get();
        System.out.println(value);

        executorService.shutdown();
    }

    static class Task implements Runnable{

        public Task(String param){
            this.var = param;
        }

        private String var;

        @Override
        public void run() {
            System.out.println(var);
        }
    }
}
