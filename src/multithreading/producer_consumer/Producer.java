package multithreading.producer_consumer;

public class Producer implements Runnable{
   QueueImp queueImp;
    public Producer(QueueImp queueImp) {
        this.queueImp = queueImp;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 500; i++) {
            queueImp.put(i++);
        }
    }
}
