package concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建带返回值的线程
 * <p>
 * 返回指定泛型的 call 方法，然后调用 FutureTask 对象的 get 方法获得 call 方法的返回值。
 *
 * @author Shadowalker
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class CreateThreadDemo4 implements Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThreadDemo4 demo4 = new CreateThreadDemo4();

        // FutureTask 最终实现的是 Runnable 接口
        FutureTask<Integer> task = new FutureTask<Integer>(demo4);

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("我可以在这里做点别的业务逻辑……因为 FutureTask 是提前完成任务");

        // 拿出线程执行的返回值
        Integer result = task.get();

        System.out.println("线程中运算的结果为：" + result);
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        int result = 1;
        System.out.println("业务逻辑计算中……");
        Thread.sleep(3000);
        return result;
    }
}
