package Semaphore.ProducerConsumer;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private int maxSize;
//    private List<Object> items; Removing list as it does not support multithreading
    private ConcurrentLinkedDeque <Object> items;
    Store(int maxSize){
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedDeque<>();
    }
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public ConcurrentLinkedDeque<Object> getItems() {
        return items;
    }

    public void setItems(ConcurrentLinkedDeque<Object> items) {
        this.items = items;
    }
    public void addItem(Object obj){
        this.items.add(obj);
        System.out.println("Producer produced item");
    }
    public Object removeItem(){
        System.out.println("Consumer consumed item");
        return this.items.remove();
    }
}
