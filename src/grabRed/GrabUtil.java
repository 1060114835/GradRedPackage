package grabRed;

import java.util.ArrayList;
import java.util.List;

public class GrabUtil {
    public static void startGrab(int peopleNum, RedPackage redPackage) {
        for (int i = 0; i < peopleNum; i++) {
            LuckyPeople temp = new LuckyPeople();
            new Thread(() -> {
                temp.grab(redPackage);
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                temp.getCurrentGrabMoney();
            }).start();
        }
    }
}
