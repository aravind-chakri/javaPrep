package multithreading.deadlock;

public class A {
    B b;
    public synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " Inside  A.foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Caught");
        }

        System.out.println(name + " trying to call b.last()");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A.last");
    }
}
