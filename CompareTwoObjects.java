import java.util.*;
import java.util.Scanner;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Student s1=new Student(23,"beyza","altinkaya",80);
        Student s2=new Student(17,"hacer","ok",70);
        Student s3=new Student(48,"emre","altin",45);
        Student s4=new Student(51,"kamil","koc",25);
        Student s5=new Student(6,"zeynep","yilmaz",67);

        List<Student> students=new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println("Before sorting");
        System.out.println(students);

        Comparator <Student> comparator=null;
        idComparator idcmp=new idComparator();
        fNameComparator fcmp=new fNameComparator();

        Scanner scn=new Scanner(System.in);

        System.out.println("Enter your choose/ 1 = id 2 = first name ");
        int a = scn.nextInt();

        if(a==1) {
            comparator = idcmp;
            Collections.sort(students, comparator);
        }

        else if(a==2) {
            comparator = fcmp;
            Collections.sort(students, comparator);
        }
        System.out.println("After sorting");
        System.out.println(students);

    }
}
class Student {
    int stId;
    String fName;
    String lName;
    int midterm;

    public Student(int stId,String name,String lname,int midterm) {
        this.stId = stId;
        this.fName=name;
        this.lName=lname;
        this.midterm=midterm;
    }

    @Override
    public String toString() {
        return "Student" +
                "stId=" + stId +
                ", fName='" + fName  +
                ", lName='" + lName  +
                ", midterm=" + midterm ;
    }
}


class idComparator implements Comparator <Student>{
    @Override
    public int compare(Student s1,Student s2){
        return s1.stId-s2.stId;
    }
}

class fNameComparator implements Comparator <Student>{
    @Override
    public int compare(Student s1, Student s2){
        return s1.fName.compareTo(s2.fName);
    }
}
