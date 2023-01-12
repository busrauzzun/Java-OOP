import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BankAccount a1=new BankAccount(21,"beyza",800.5);
        BankAccount a2=new BankAccount(58,"hacer",244.3);
        BankAccount a3=new BankAccount(64,"zeynep",118.0);
        BankAccount a4=new BankAccount(11,"feyza",1050.7);

        ArrayList <BankAccount> myAccounts= new ArrayList<BankAccount>();
        myAccounts.add(a1);
        myAccounts.add(a2);
        myAccounts.add(a3);
        myAccounts.add(a4);

        Collections.sort(myAccounts);

        Iterator itr=myAccounts.iterator();

        BankAccount[] accounts={a1,a2,a3,a4};
        for(BankAccount a: accounts){
            a.balanceChange(100.0);
        }

        while(itr.hasNext()){
            System.out.println(itr.next());
        }


    }
}

class BankAccount implements Comparable <BankAccount>{
    int accountNo;
    String holderName;
    double balance;

    BankAccount(int accountNo,String hName,double balance){
        this.accountNo=accountNo;
        this.holderName=hName;
        this.balance=balance;
    }

    void balanceChange(double amount){
        this.balance-=amount;
    }

    @Override
    public int compareTo(BankAccount other){
        return this.holderName.compareTo(other.holderName);
    }

    @Override
    public String toString(){
        return "No:"+ this.accountNo+ " " + "name=" +this.holderName+ " "+ "balance="+ this.balance;
    }
}
