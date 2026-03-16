package multithreading.deadlock;

public class B  {
    A a;

    public synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " Inside B.bar");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException e");
        }
        System.out.println(name + " trying to call a.last()");
        a.last();
    }
    public synchronized void last() {
        System.out.println("Inside b.last");
    }
}
