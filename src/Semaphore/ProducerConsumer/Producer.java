package Semaphore.ProducerConsumer;

import java.util.concurrent.Semaphore;

public class Producer implements  Runnable{
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    Producer(Store store,Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
        this.store = store;
    }
    @Override
    public void run() {
        while (true){
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.addItem(new Object());
            consumerSemaphore.release();
        }
    }
}
