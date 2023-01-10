public class Main {
    public static void main(String[] args) {

        Employee e1= new Employee("Kemal",3000,42,2002);
        e1.toString();

    }
}
class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;

    Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours=workHours;
        this.hireYear=hireYear;

    }
    double tax(){
        double tax=0.0;
        if(this.salary<1000){
            System.out.println("No tax!");
        }
        else{
            tax=(this.salary)*0.03;
        }
        return tax;
    }

    int bonus(){
        int bonus=0;
        if(this.workHours>40){
            bonus=(this.workHours-40)*30;
        }
        else{
            System.out.println("No bonus !");
        }
        return bonus;
    }

    double raiseSalary(){
        double addition=0.0;
        if((2021-this.hireYear)<10){
            addition=this.salary*0.05;
        }
        else if ((2021-this.hireYear)>9&& (2021-this.hireYear)<20) {
            addition=this.salary*0.1;
        }
        else {
            addition=this.salary*0.15;
        }
        return addition;
    }

    public String toString(){
        double total =this.salary-tax()+bonus()+raiseSalary();
        double tot=this.salary+bonus()-tax();

        System.out.println("Name: "+this.name);
        System.out.println("Salary: "+this.salary);
        System.out.println("Working hours: "+this.workHours);
        System.out.println("Hire year: "+this.hireYear);
        System.out.println("Tax: "+tax());
        System.out.println("Bonus: "+bonus());
        System.out.println("Raise salary: "+raiseSalary());
        System.out.println("With tax and bonus: "+tot);
        System.out.println("Total salary: "+total);

        return null;
    }
}
