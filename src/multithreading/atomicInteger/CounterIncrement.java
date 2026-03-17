package multithreading.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterIncrement {
    private static final AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        for(int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        CounterIncrement counterIncrement  = new CounterIncrement();
        Thread thread1 = new Thread(counterIncrement::increment);
        Thread thread2 = new Thread(counterIncrement::increment);
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e)
        {
        }
        System.out.println("Count: " + CounterIncrement.count);
    }
}
