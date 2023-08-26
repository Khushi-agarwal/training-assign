class InsufficientBalanceException extends RuntimeException
{
    private double amount;
    private String message=null;
    public InsufficientBalanceException(double amount)
    {
        this.amount=amount;
        message="Your existing amount is not sufficient"+amount;
    }
    public InsufficientBalanceException(double amount,String message)
    {
        this.amount=amount;
        this.message=message;
    }
    public String getMessage()
    {
        return message;
    }
    public String toString(){
        return "InsufficientBalance exception:"+message+" "+amount;
    }
}


class acc
{
    int accno;
    String accname;
    String date;
    String status;
    double balance;
    acc(int accno,String accname,String date,String status,double balance)
    {
        this.accno=accno;
        this.accname=accname;
        this.date=date;
        this.status=status;
        this.balance=balance;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAccno() {
        return accno;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccname() {
        return accname;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
 class transact
{
    public void deposit(acc a,double amount)
    {
        a.balance+=amount;
    }
    public void withdraw(acc a,double amount)
    {
        if(a.balance<amount)
            throw new InsufficientBalanceException(amount,"Insufficient balance");
        else {
            a.balance = a.balance - amount;
            System.out.println(a.balance);}

    }

}
public class assign {
    public static void main(String args[])
    {
        acc obj=new acc(102,"Khushi","25/08/2023","Active",5000.00);
        transact tt=new transact();
        tt.deposit(obj,4000);
        tt.withdraw(obj,1000);


    }
}
