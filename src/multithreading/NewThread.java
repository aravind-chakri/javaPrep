package multithreading;

public class NewThread implements Runnable{
    Thread t;
    String name;

    public NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Child thread is: " + t);
        t.start();
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Child thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted");
            }
        }
        System.out.println("Child thread exited");
    }
}
