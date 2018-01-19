package concurrencyapi.lesson06.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SyncEx02 {
    /*Для синхронизации потоков в
    * Concurrency API предусмотрен
    * Lock API*/
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        Counter counter = new Counter();

        ExecutorService service =
                Executors.newFixedThreadPool(2);
        service.submit(() -> {
            /*lock() - позволяет установить блокировку потока*/
            reentrantLock.lock();
            /*isHeldByCurrentThread() - проверка установлена ли
            *                           блокировка в текущем потоке*/
            if (reentrantLock.isHeldByCurrentThread()) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Выполнение задачи 1");
                    for (int i = 0; i < 500; i++) {
                        counter.increment();
                    }
                    System.out.println("*******************");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /*Завершаем блокировку */
            reentrantLock.unlock();
        });

        service.submit(() -> {
            /*Проверка синхронизации
            * isLocked() - проверяет установлена ли блокировка
            * в параллельном потоке*/
            while (reentrantLock.isLocked()) {
                try {
                    System.out.print("Попітка захвата -> ");
                    TimeUnit.MILLISECONDS.sleep(250);
                    System.out.println("Не успешно");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /*tryLock() - проверяем возможность захватить контроль*/
            try {
                while (!reentrantLock.tryLock(100, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (reentrantLock.isHeldByCurrentThread()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Віполнение задачи 2");
                    for (int i = 0; i < 250; i++) {
                        counter.increment();
                    }
                    System.out.println("*******************");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reentrantLock.unlock();
        });


        service.shutdown();
    }
}
