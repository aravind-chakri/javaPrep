package multithreading.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorDemo {
    private static final AtomicInteger count = new AtomicInteger(0);
    public static void increment() {
        for(int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(ExecutorDemo::increment);
        executor.submit(ExecutorDemo::increment);


        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Count is: " + count);
    }
}
