package multithreading;

public class MultiThreadingDemo {

    public static void main(String[] args) throws InterruptedException {
//        MyThread thread = new MyThread();
//        MyThread thread1 = new MyThread();
//        thread.start();
//        thread1.start();
        for(int i = 0; i < 3; i++) {
            MyRunnable myRunnable = new MyRunnable(i);
            Thread thread1 = new Thread(myRunnable);
            thread1.start();
        }
    }

}
