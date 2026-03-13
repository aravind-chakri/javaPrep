package multithreading;

public class MyRunnable implements Runnable{

    private int threadNumber;

    public MyRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            Thread.currentThread().setPriority(threadNumber + 1);
            System.out.println(i + " From Thread " + threadNumber + " and thread priority: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error message: " + e.getMessage());
            }
        }
    }
}
