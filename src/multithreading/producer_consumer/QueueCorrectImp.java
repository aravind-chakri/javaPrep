package multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCorrectImp implements QueueImp{
    boolean valueSet = false;
    Queue<Integer> queue = new LinkedList<>();

    public synchronized void put(Integer num) {
        while(valueSet) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("Interrupted Exception Caught");
            }
        }
        valueSet = true;
        notify();
        System.out.println("Put : " + num);
        queue.add(num);
    }

    public synchronized void get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Caught");
            }
        }
        valueSet = false;
        notify();
        System.out.println("Get " + queue.poll());
    }
}
