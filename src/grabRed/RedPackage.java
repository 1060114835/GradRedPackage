package grabRed;

//当红包规则为公平时，sumPeople才有值，否则为-1.
public class RedPackage {

    private int sumMoney;

    private boolean isFair;

    private int sumPeople;


    public RedPackage(int sumMoney, boolean isFair, int sumPeople) {
        this.sumMoney = sumMoney;
        this.isFair = isFair;
        this.sumPeople = sumPeople;
    }

    public RedPackage(int sumMoney) {
        this(sumMoney, false, -1);
    }

    public int graded(int money) {

    }

    public int getSumMoney() {
        return sumMoney;
    }


    public boolean isFair() {
        return isFair;
    }

    public int getSumPeople() {
        return sumPeople;
    }
}