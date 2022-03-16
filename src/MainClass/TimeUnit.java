package MainClass;

import java.util.Timer;
import java.util.TimerTask;

public class TimeUnit{
    static int second = 0;
    static Timer time;
    public static void counter(){
        second++;
        System.out.println(second);
        if(second == 10){
            time.cancel();
        }
    }

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter();
            }
        };
        time = new Timer();
        time.schedule(timerTask,1000,1000);
    }
}
