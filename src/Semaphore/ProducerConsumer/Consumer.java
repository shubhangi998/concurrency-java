package Semaphore.ProducerConsumer;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Semaphore consumerSemaphore;
    private Semaphore producerSemaphore;
    private Store store;
    Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
        this.store = store;
    }
    @Override
    public void run() {
        while (true){
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Object item = store.removeItem();
            producerSemaphore.release();
        }
    }
}
