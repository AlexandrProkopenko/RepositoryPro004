package concurrencyapi.lesson06;

import java.util.concurrent.TimeUnit;

public class Counter {

    private int count = 0;

    public void increment() {
        count++;
    }

    public void syncIncrement() {
        synchronized (this) {
            count++;
        }
    }

    public synchronized void sync(String threadName) {
        System.out.print(threadName);
        count++;
        System.out.println(" -> " + count);
    }

    public void syncBlock(String threadName) {
        System.out.print(threadName);
        synchronized (this) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        System.out.println(" -> " + count);
    }

    public int value() {
        return count;
    }
}
