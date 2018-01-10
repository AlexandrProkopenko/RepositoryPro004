package concurrencyapi.lesson05;

import java.util.concurrent.*;

public class CallableExConcurrencyAPI {
    //Callable - включен в состав Concurrency API
    //           позволяет нам вернуть результат
    //           выполнения фонового процесса
    public static void main(String[] args) {
        Callable<String> task1 = () -> {
            System.out.println("Поток который что-то делает");
            TimeUnit.SECONDS.sleep(2);
            return "Результат выполнения потока";
        };

        ExecutorService es = Executors.newFixedThreadPool(1);

        Future<String> f = es.submit(task1);

        try {
            System.out.println("Ожидание результата...");
            System.out.println("Задача завершена? " + f.isDone());
            String result = f.get(3, TimeUnit.SECONDS);
            System.out.println("Задача завершена? " + f.isDone());
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}
