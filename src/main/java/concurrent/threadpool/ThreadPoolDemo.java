package concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池
 * <p>
 * IO 密集，用多线程优化，可以提升性能。
 * <p>
 * 计算密集，多线程不一定能够提升性能，反而由于线程切换会消耗性能。
 *
 * @author Shadowalker
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ThreadPoolDemo {

    public static void main(String[] args) throws Exception {

        invokeWithoutMultiThread();
        invokeWithMultiThread();
    }

    private static void invokeWithoutMultiThread() throws Exception {

        long startTime = System.currentTimeMillis();

        // 第一个 RPC 接口，调用花费 100ms
        Thread.sleep(100);

        // 第一个 RPC 接口，调用花费 100ms
        Thread.sleep(100);

        // 第一个 RPC 接口，调用花费 100ms
        Thread.sleep(100);

        // 第一个 RPC 接口，调用花费 100ms
        Thread.sleep(100);

        long endTime = System.currentTimeMillis();

        System.out.println("不使用多线程，四个接口调用完毕，组合结果返回，总共耗时：" + (endTime - startTime) + "ms。");
    }

    private static void invokeWithMultiThread() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long startTime = System.currentTimeMillis();

        try {
            List<Callable<String>> callableList = new ArrayList<>();

            // 第一个 RPC 接口，调用花费 100ms
            Callable<String> callableA = () -> {
                Thread.sleep(100);
                return "A";
            };
            callableList.add(callableA);

            // 第二个 RPC 接口，调用花费 200ms
            Callable<String> callableB = () -> {
                Thread.sleep(200);
                return "B";
            };
            callableList.add(callableB);

            // 第三个 RPC 接口，调用花费 150ms
            Callable<String> callableC = () -> {
                Thread.sleep(150);
                return "C";
            };
            callableList.add(callableC);

            // 第四个 RPC 接口，调用花费 300ms
            Callable<String> callableD = () -> {
                Thread.sleep(300);
                return "D";
            };
            callableList.add(callableD);

            List<Future<String>> futureList = executorService.invokeAll(callableList);
            StringBuilder stringBuilder = new StringBuilder();
            for (Future<String> future : futureList) {
                stringBuilder.append(future.get());
            }

            long endTime = System.currentTimeMillis();

            System.out.println("使用多线程，四个接口调用完毕，组合结果返回：" + stringBuilder.toString() + "，总共耗时：" + (endTime - startTime) + "ms。");
        } finally {
            executorService.shutdown();
        }
    }
}
