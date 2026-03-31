package multithreading;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException i) {
            }
        };

        int threadCount = 10000;
        List<Thread> threadList = new ArrayList<>();

        for(int i = 0; i < threadCount; i++) {
            Thread thread = Thread.ofVirtual().unstarted(runnable);
            thread.setName("thread: " + i);
            thread.start();
            System.out.println("Started thread: " + i);
            threadList.add(thread);
        }

        for(Thread thread : threadList) {
            thread.join();
            System.out.println("Completed " + thread.getName());
        }


    }
}
