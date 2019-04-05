package grammer.multithread;

/**
 * @author xuan
 * @date 2019-03-30 18:26.
 */

public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromaccount;
    private double maxAmount;
    private int DELAY=10;

    public TransferRunnable(Bank b ,int from,double max){
        bank =b;
        fromaccount=from;
        maxAmount=max;
    }

    @Override
    public void run() {
        try{
            while (true){
                int toAccount=(int)(bank.size()*Math.random());
                double amount= maxAmount * Math.random();
                bank.transfer(fromaccount,toAccount,amount);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
