import java.io.*;

public class Main {
    public static void main(String[] args) {

        String path="C:\\Users\\busra\\OneDrive\\Masaüstü\\Java101\\file.txt";
        Student s1=new Student(23,"busra",95,89);
        try {
            Student.savetoFile(path);
            Student c =null;
            c=Student.getFromFile(path);
            System.out.println(c.getfName());

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class Student implements Serializable {
    private int id;
    private String fName;
    private int midterm;
    private int finalexam;

    public Student(int id, String fName, int midterm, int finalexam) {
        this.id = id;
        this.fName = fName;
        this.midterm = midterm;
        this.finalexam = finalexam;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public int getMidterm() {
        return midterm;
    }

    public int getFinalexam() {
        return finalexam;
    }

    public static void savetoFile(Student s,String path)throws Exception{
        FileOutputStream outputFile =new FileOutputStream(path);
        ObjectOutputStream output =new ObjectOutputStream(outputFile);
        output.writeObject(s);
        output.close();
    }

    public static Student getFromFile(String path)throws Exception{
        FileInputStream inputFile=new FileInputStream(path);
        ObjectInputStream input=new ObjectInputStream(inputFile);
        Student s =(Student) input.readObject();
        input.close();
        return s;
    }
}
