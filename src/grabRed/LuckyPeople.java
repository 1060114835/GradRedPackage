package grabRed;

public class LuckyPeople implements GrabHandler, Runnable{

    private int currentGrabMoney = 0;

    @Override
    public int grab(RedPackage redPackage) {
        synchronized (redPackage) {
            if (redPackage.isFair()) {
                redPackage.getSumMoney()
            }
        }
        return 0;
    }

    @Override
    public void run() {

    }
}
