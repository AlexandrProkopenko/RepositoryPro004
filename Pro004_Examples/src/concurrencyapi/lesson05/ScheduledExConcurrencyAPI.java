package concurrencyapi.lesson05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExConcurrencyAPI {

    public static void main(String[] args) {
        System.out.println("Старт метода main()");
        /*Класс ScheduledExecutorService
        *   - предназначен для отложенного запуска задач*/

        Runnable task = () -> {
            System.out.println("Отложеная для выполнения задача");
        };

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        ScheduledFuture sf = ses.schedule(task, 5, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Время до запуска: " + sf.getDelay(TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершение метода main()");
        System.out.println(sf.isDone());
        ses.shutdown();
    }
}
