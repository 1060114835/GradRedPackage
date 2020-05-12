package grabRed;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LuckyPeople implements GrabHandler{

    private int currentGrabMoney = 0;

    @Override
    public int grab(@NotNull RedPackage redPackage) {
            if (redPackage.isFair()) {
                currentGrabMoney = redPackage.getSumMoney() / redPackage.getSumPeople();
                redPackage.getLock().lock();
                redPackage.reduce(currentGrabMoney);
                redPackage.getLock().unlock();
            } else {
                redPackage.getLock().lock();
                //如果当前红包数额少于0.5元，则全部分给当前用户
                if (redPackage.isEmpty()) {
                    currentGrabMoney = 0;
                } else if (redPackage.getCurrentSumMoney() < 50) {
                    currentGrabMoney = redPackage.getCurrentSumMoney();
                    redPackage.clear();
                } else {
                    Random random = new Random();
                    currentGrabMoney = random.nextInt(redPackage.getCurrentSumMoney());
                    redPackage.reduce(currentGrabMoney);
                }
                redPackage.getLock().unlock();
            }
        return currentGrabMoney;
    }

    public double getCurrentGrabMoney() {
        double temp = currentGrabMoney / 100.0;
        System.out.println(Thread.currentThread().getName() + " 抢到 " + temp + " 元");
        return temp;
    }
}
