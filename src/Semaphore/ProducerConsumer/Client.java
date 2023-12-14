package Semaphore.ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        Store store = new Store(5);
        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);
        for(int i = 0 ; i<10 ; i++){
            es.execute(new Producer(store,producerSemaphore,consumerSemaphore));
        }
        for(int j = 0 ; j < 10 ; j++){
            es.execute(new Consumer(store,producerSemaphore,consumerSemaphore));
        }

    }

}
