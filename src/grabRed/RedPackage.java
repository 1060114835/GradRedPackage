package grabRed;

import org.w3c.dom.css.CSSUnknownRule;

import java.util.concurrent.locks.ReentrantLock;

//当红包规则为公平时，sumPeople才有值，否则为-1.
public class RedPackage {

    private int sumMoney;

    private boolean isFair;

    private int sumPeople;

    private int currentSumMoney;

    private ReentrantLock lock;


    public RedPackage(int sumMoney, boolean isFair, int sumPeople) {
        this.sumMoney = sumMoney * 100;
        this.isFair = isFair;
        this.sumPeople = sumPeople;
        this.currentSumMoney = this.sumMoney;
        lock = new ReentrantLock();
    }

    public RedPackage(int sumMoney) {
        this(sumMoney, false, -1);
    }

    public void reduce(int money) {
        currentSumMoney -= money;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public int getCurrentSumMoney() {
        return currentSumMoney;
    }

    public boolean isFair() {
        return isFair;
    }

    public int getSumPeople() {
        return sumPeople;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public boolean isEmpty() {
        return currentSumMoney == 0;
    }

    public void clear() {
        currentSumMoney = 0;
    }
}