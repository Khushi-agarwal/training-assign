//Make a bankaccount class and transaction class such that the find balance thread is called always before the read balance thread.
import javax.naming.InsufficientResourcesException;
import java.util.concurrent.Semaphore;
public class BankAccount
{
    private int accountNo;
    private double balance;
    public BankAccount(){}
    public BankAccount(int accountNo,double balance)
    {
        this.accountNo=accountNo;
        this.balance=balance;
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

}
class Transaction
{
    Semaphore findBalance=new Semaphore(0);
    Semaphore modifyBalance=new Semaphore(1);
    public  void transact(BankAccount acc,double amount,char ttype)
    {
        try
        {
            modifyBalance.acquire();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        if(ttype=='D' || ttype=='d')
        acc.setBalance(acc.getBalance()+amount);
        else if(ttype=='W' || ttype=='w')
            acc.setBalance(acc.getBalance()-amount);
        findBalance.release();

    }
    public void checkBalance(BankAccount acc)
    {
        try
        {
            findBalance.acquire();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        System.out.println(acc.getBalance());
        modifyBalance.release();
    }
}

class ModifyBalanceThread implements Runnable {
    BankAccount acc;
    Transaction trans;
    double amount;
Thread t;
    public ModifyBalanceThread(BankAccount acc, Transaction trans, double amount) {
        this.acc = acc;
        this.trans = trans;
        this.amount = amount;
        t=new Thread(this);
        t.start();
    }

    public void run() {
        trans.transact(acc, amount, 'D');
        System.out.println(acc.getAccountNo()+" Balance is modified");
    }
}
class FindBalanceThread implements Runnable
{
    BankAccount acc;
    Transaction trans;
    Thread t;
    public FindBalanceThread(BankAccount acc,Transaction trans)
    {
        this.acc=acc;
        this.trans=trans;
       t= new Thread(this);
       t.start();
    }
    public void run()
    {
        trans.checkBalance(acc);
    }

}

class Test123
{
    public static void main(String[] args) {
        BankAccount acc1=new BankAccount(7001,15000);
        Transaction trans1=new Transaction();
        FindBalanceThread fbt=new FindBalanceThread(acc1,trans1);
        ModifyBalanceThread mbt=new ModifyBalanceThread(acc1,trans1,3000.45);
        try
        {
            fbt.t.join();
            mbt.t.join();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}

