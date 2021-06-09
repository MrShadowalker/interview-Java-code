package concurrent.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器 Timer
 *
 * @author Shadowalker
 */
@SuppressWarnings("AlibabaAvoidCommentBehindStatement")
public class CreateThreadDemo5 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器线程执行了……");
            }
        }, 0, 1000); // 延迟 0， 周期 1s
    }
}
