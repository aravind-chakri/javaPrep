package multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class QueueWrongImplementation implements QueueImp {
    Queue<Integer> queue = new LinkedList<>();

    public synchronized void put(Integer num) {
        System.out.println("Put : " + num);
        queue.add(num);
    }

    public synchronized void get() {
        System.out.println("Get " + queue.poll());
    }

}
