package concurrencyapi.lesson06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncEx03 {

    private static String someValue = "null";

    public static void main(String[] args) {
        ReadWriteLock locker = new ReentrantReadWriteLock();

        ExecutorService service =
                Executors.newFixedThreadPool(5);

        service.submit(() -> {
            try {
                    TimeUnit.SECONDS.sleep(3);
                    locker.writeLock().lock();
                    System.out.println("Начало записи данных");
                    TimeUnit.MILLISECONDS.sleep(250);
                    someValue = "ЗапиCCаные даHHые";
                    TimeUnit.MILLISECONDS.sleep(250);
                    System.out.println("Завершение записи данных");
                    locker.writeLock().unlock();
                    TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.submit(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    TimeUnit.MILLISECONDS.sleep(750);
                    System.out.print(Thread.currentThread().getName() + " -> ");
                    locker.readLock().lock();
                    System.out.println(someValue);
                    locker.readLock().unlock();
                    TimeUnit.MILLISECONDS.sleep(750);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.submit(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    TimeUnit.MILLISECONDS.sleep(950);
                    System.out.print(Thread.currentThread().getName() + " -> ");
                    locker.readLock().lock();
                    System.out.println(someValue);
                    locker.readLock().unlock();
                    TimeUnit.MILLISECONDS.sleep(950);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.submit(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    TimeUnit.MILLISECONDS.sleep(350);
                    System.out.print(Thread.currentThread().getName() + " -> ");
                    locker.readLock().lock();
                    System.out.println(someValue);
                    locker.readLock().unlock();
                    TimeUnit.MILLISECONDS.sleep(350);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
    }
}
