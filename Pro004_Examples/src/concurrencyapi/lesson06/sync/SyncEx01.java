package concurrencyapi.lesson06.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SyncEx01 {

    public static void main(String[] args) {
        Counter counter = new Counter();

        ExecutorService service =
                Executors.newFixedThreadPool(2);

        service.submit(() -> {
            for (int i = 0; i < 500_000; i++) {
//                counter.increment();
//                counter.syncIncrement();
//                counter.sync(Thread.currentThread().getName());
                counter.syncBlock(Thread.currentThread().getName());
            }
        });

        service.submit(() -> {
            for (int i = 0; i < 500_000; i++) {
//                counter.increment();
//                counter.syncIncrement();
//                counter.sync(Thread.currentThread().getName());
                counter.syncBlock(Thread.currentThread().getName());
            }
        });

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            service.shutdown();
            System.out.println(counter.value());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
