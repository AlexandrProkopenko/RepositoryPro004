package concurrencyapi.lesson05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledEx02ConcurrencyAPI {

    public static void main(String[] args) {
        System.out.println("Старт Метода main()");
        ScheduledExecutorService ses =
                Executors.newScheduledThreadPool(42);
        ses.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Начало фоновой задачи");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Что-то делает...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Завершение фоновой задачи");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 4, TimeUnit.SECONDS);

        //ses.shutdown();
        System.out.println("Завершение Метода main()");
    }
}
