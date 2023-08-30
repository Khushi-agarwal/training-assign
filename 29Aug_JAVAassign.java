package com.Aug29;

import javax.naming.InsufficientResourcesException;

public class BankAccount {

    int accountNumber;
    String accountStatus;
    String openedDate;
    double balanceAmount;
    BankAccount(){};
    BankAccount(int accountNumber,String accountStatus,String openedDate,double balanceAmount)
    {
        this.accountNumber=accountNumber;
        this.accountStatus=accountStatus;
        this.openedDate=openedDate;
        this.balanceAmount=balanceAmount;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setAccountStatus(String accountStatus)
    {
        this.accountStatus=accountStatus;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public void setOpenedDate(String openedDate) {
        this.openedDate = openedDate;
    }
}
class Transaction
{

    synchronized public static void deposit(BankAccount acc,double amount)
    {
        acc.balanceAmount+=amount;

    }
   synchronized public static void withdraw(BankAccount acc,double amount) throws InsufficientResourcesException {
        if(checkBalance(acc)<amount)
            throw new InsufficientResourcesException();
        else {
            acc.balanceAmount -= amount;
            System.out.println(acc.balanceAmount);}


    }
   synchronized public static double checkBalance(BankAccount acc)
    {
        return acc.balanceAmount;
    }
}
class BalanceModifyThread implements  Runnable
{
    Thread t;
    Transaction t1;
    BankAccount ba;
    BalanceModifyThread(Transaction t1,BankAccount ba)
    {
        t=new Thread(this);
        this.t1=t1;
        this.ba=ba;
        t.start();
    }


    public void run() {
        try {
            t1.deposit(ba,9000);
            t1.withdraw(ba,5000);

        } catch (InsufficientResourcesException e) {
            throw new RuntimeException(e);
        }

    }
//it widthdraws money and should be able to access checkBalance
    //preference should be given to this thread
}
class ReadBalanceThread implements Runnable{

    Thread t;
    Transaction t3;
    BankAccount ba;
    ReadBalanceThread(Transaction t3,BankAccount ba)
    {
        t=new Thread(this);
        this.t3=t3;
        this.ba=ba;
        t.start();
    }


    public void run() {
        System.out.println( t3.checkBalance(ba));


    }
    //it should access the check balance
}
class testinggg
{
    public static void main(String[] args) {
        BankAccount ba=new BankAccount(101,"Active","23/08/2023",90000);

        Transaction t1=new Transaction();
        BalanceModifyThread bt=new BalanceModifyThread(t1,ba);
        ReadBalanceThread rt=new ReadBalanceThread(t1,ba);
        try
        {
            bt.t.join();
            rt.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }
    }
}
