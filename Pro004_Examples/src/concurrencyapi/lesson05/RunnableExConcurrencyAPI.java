package concurrencyapi.lesson05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableExConcurrencyAPI {

    /*Concurrency API - библиотека удобных
    * инструментов для управления потоками*/

    public static void main(String[] args) throws InterruptedException {
        //Подготовка и создание Runnable
        //задачи
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Задание для выполнения (1)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Задание для выполнения (2)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //Исполнитель - основное назначение исполнителя, заключается
        //в том, чтобы запустить задачу в фоне
        //Создание класса Исполнителя
        //ExecutorService - данный интерфейс предоставляет возможность
        //                  организовать работу с классом исполнителем
        //Executors       - данный класс позволяет нам создать
        //                  исполнителей
        //newSingleThreadExecutor() - создает исполнителя с 1-им
        //                            фоновым процессом
        ExecutorService es = Executors.newSingleThreadExecutor();

        es.execute(task);
        es.execute(task2);

        es.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Задание для выполнения (3)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            while (true) {
//                System.out.println("Что-то");
//            }
        });

        //"Вежливая" форма остановки работі сервиса
        //es.shutdown();
        TimeUnit.SECONDS.sleep(3);

        //Правильная остановка исполнителя
        if (!es.isTerminated()) {
            try {
                System.out.println("Подготовка к остановке Исполнителя...");
                System.out.println("Ожидание 3 сек.");
                es.awaitTermination(3, TimeUnit.SECONDS);
                System.out.println("Досрочная остановка Исполнителя...");
                es.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
