package multithreading.producer_consumer;

public class Consumer implements Runnable {
    QueueImp queueImp;

    public Consumer(QueueImp queueImp) {
        this.queueImp = queueImp;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 500; i++) {
            queueImp.get();
        }
    }
}
