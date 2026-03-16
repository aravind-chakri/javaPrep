package multithreading.producer_consumer;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        QueueImp queueImp = new QueueCorrectImp();
        Producer p = new Producer(queueImp);
        Consumer q = new Consumer(queueImp);
        System.out.println("Press Control-C to Stop");
    }
}
