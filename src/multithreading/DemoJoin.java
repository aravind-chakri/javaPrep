package multithreading;

public class DemoJoin {
    public static void main(String[] args) {
        // without using joints
//        new NewThread("Demo thread");
//        for(int i = 0; i < 5; i++) {
//            System.out.println("Main thread: " + i);
//            try{
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Main thread interrupted");
//            }
//        }
//        System.out.println("Main thread exited");


        // with join() method
        NewThread obj1 = new NewThread("one");
        NewThread obj2 = new NewThread("two");
        NewThread obj3 = new NewThread("three");

        System.out.println("Thread one is alive: " + obj1.t.isAlive());
        System.out.println("Thread two is alive: " + obj2.t.isAlive());
        System.out.println("Thread three is alive: " + obj3.t.isAlive());

        try {
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Threads are interrupted");
        }

        System.out.println("Thread one is alive: " + obj1.t.isAlive());
        System.out.println("Thread two is alive: " + obj2.t.isAlive());
        System.out.println("Thread three is alive: " + obj3.t.isAlive());

        System.out.println("Main thread exited");
    }
}
