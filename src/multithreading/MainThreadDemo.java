package multithreading;

public class MainThreadDemo {

    public static void main(String[] args) {

        Thread t = Thread.currentThread();

        System.out.println("Current thread: " + t);

        //change the name of the thread
        t.setName("CustomThread");
        t.setPriority(10);

        System.out.println("After name change: " + t);

        try {
            for(int i = 1; i <= 5; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
