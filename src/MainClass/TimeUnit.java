package MainClass;

import java.util.Timer;
import java.util.TimerTask;

public class TimeUnit{
    static int second = 0;
    public static void counter(){
        second++;
        System.out.println(second);
    }

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter();
            }
        };
        Timer time = new Timer();
        time.schedule(timerTask,1000,1000);
    }
}
