package multithreading.deadlock;

public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();

    public DeadLock() {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();

        a.foo(b);
        System.out.println("Back in the main Thread");
    }

    @Override
    public void run() {
        b.bar(a);
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}
