package concurrencyapi.lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllConcurrencyAPI {

    public static void main(String[] args) {
        List<Callable<Integer>> tasks = new ArrayList<>();

        Callable<Integer> task1 = () -> {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Task01");
            return 100;
        };
        Callable<Integer> task2 = () -> {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Task02");
            return 200;
        };
        Callable<Integer> task3 = () -> {
            TimeUnit.SECONDS.sleep(7);
            System.out.println("Task03");
            return 300;
        };

        tasks.addAll(Arrays.asList(task1, task2, task3));

        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            List<Future<Integer>> res = es.invokeAll(tasks);
            for (Future<Integer> f : res) {
                System.out.println(f.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}
