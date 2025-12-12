package ooplab;

public class Bank {
    private final Account[] accountarray = new Account[3];
    private int id = 1;

    public Account addAccount(String owner, double balance){
        for (int i = 0; i < accountarray.length; i++){
            if(accountarray[i] == null){
                Account a = new Account(id++, owner, balance);
                accountarray[i] = a;
                return a;
            }
        } return null;
    }


    public Account getAccount(String owner){
        for(Account a: accountarray){
            if(a != null && a.getOwner().equals(owner)) return a;
        } return null;
    }
}

***
account:


package ooplab;

public class Account {
    private int id; 
    private String owner; 
    private double balance;

    public Account(int id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    protected void deposit(double amount){
        if (amount <= 0){
        throw new IllegalArgumentException("Deposit must be positive!");}
        else {balance += amount;}
    }

    protected void withdraw(double amount){
    if (amount <= 0 || amount > balance){
        throw new IllegalArgumentException("withdrawal must be positive and not exceed balance");}
        else {balance -= amount;}
    }

    // @Override
    // public String toString() {
    //     return "Account [id=" + id + ", owner=" + owner + ", balance=" + balance + "]";
    // }

    protected String getDetails(){
        return "Id: "  + id + " " + owner + " " + balance;
    }

    protected void addInterest(){
        balance += (balance * 0.025);
    }

    protected static void processAccount(Account acc){ 
	    acc.addInterest();

    }  

    protected String getOwner(){
        return owner;
    }
}


***
main:

public class Program {
public static void main(String[] args) {

    Bank bank = new Bank();

    Account x = bank.addAccount("c", 100);
    Account y = bank.addAccount("d", 100);
    Account z = bank.addAccount("e", 100);

    System.out.println(x.getDetails());
    System.out.println(y.getDetails());
    System.out.println(z.getDetails());
    
    Account searchResult = bank.getAccount("c");
    System.out.println(searchResult.getDetails());





    // Account acc = new Account(1,"chirs",100);

    // acc.withdraw(50);
    // //acc.withdraw(100);
    // acc.deposit(10);
    // System.out.println(acc.getDetails());


    // Account[] accounts = {
    //     new Account(2, "a", 10),
    //     new Account(3, "b", 10),
    //     new Account(4, "c", 10)
    // };

    // for (Account a : accounts){
    //     System.out.println(a.getDetails());
    // }


    // Account myAccount = new Account(5, "d", 100);
    // myAccount.addInterest();
    // System.out.println(myAccount.getDetails());

    // Account partnerAccount = myAccount;

    // partnerAccount.addInterest();
    // System.out.println(myAccount.getDetails());

    // processAccount(myAccount);
    // System.out.println(myAccount.getDetails());

}
// protected static void processAccount(Account acc){ 
// 	    acc.addInterest();

    // } 
}
