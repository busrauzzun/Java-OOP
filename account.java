import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Acount person1=new Acount(350.0,"Jack");
        person1.setOwnerName("July");
        System.out.println(" "+person1.getOwnerName());
        person1.addAmount(55.0);
        person1.withdraw(45.0);
        System.out.println(" "+person1.getBalance());

    }
}
class Acount {
    private double balance;
    private String ownerName;
    private String password;

    Acount(double balance,String ownerName) {
        this.balance=balance;
        this.ownerName=ownerName;
        password="10032000";

    }

    public void setOwnerName(String name){
        this.ownerName=name;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    void addAmount(double amount){
        this.balance+=amount;
    }

    void withdraw(double amount){

        Scanner inpt=new Scanner(System.in);
        String userPassword;
        Boolean isMAtched=false;

        for(int i=0;i<3;i++){
            System.out.println("Enter your password :");
            userPassword=inpt.nextLine();
            if(userPassword.equals(this.password)){
                isMAtched=true;
                this.balance-=amount;
                break;
            }

        }
        if(!isMAtched){
            System.out.println("Your account has been blocked ");
        }

    }

    public double getBalance() {
        return balance;
    }
}

