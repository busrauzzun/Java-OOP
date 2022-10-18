public class Main {
    public static void main(String[] args) {
        Teacher t1=new Teacher("Mahmut", "TRH","0056330393");
        Teacher t2=new Teacher("Ali", "FZK","005787904");
        Teacher t3=new Teacher("Alime", "MAT","230484849");

        Course tarih=new Course("tarih","101","TRH");
        Course fizik=new Course("fizik","105","FZK");
        Course mat=new Course("matematik","203","MAT");

        tarih.addTeacher(t1);
        fizik.addTeacher(t2);
        mat.addTeacher(t3);


        Student s1= new Student("Beyza","201","3A",tarih,fizik,mat);
        s1.addExamNote(80,70,90);
        s1.addSozlu(100,90,80);
        s1.printNote();
        s1.calcAverage();
        s1.isPass();

    }
}

class Teacher {
    String name;
    String mphno;
    String branch;

    Teacher(String name, String branch,String mphno){
        this.name=name;
        this.branch=branch;
        this.mphno=mphno;

    }
    void print(){
        System.out.println(""+this.name);
        System.out.println(""+this.branch);
        System.out.println(""+this.mphno);


    }
}

class Course {
    String name;
    String code;
    String prefix;
    int note;
    int sozlu;
    Teacher teacher;   // We create a reference .We did't assign a value.

    Course(String name, String code, String prefix){
        this.name=name;
        this.prefix=prefix;
        this.code=code;
        int note=0;
        int sozlu=0;
    }

    void addTeacher(Teacher teacher){
        if(teacher.branch.equals(this.prefix)){
            this.teacher=teacher;
        }
        else {
            System.out.println("Ogretmen ve ders bolumleri uyusmuyor");
        }
    }

    void printInfo(){
        this.teacher.print();
    }
}

class Student {
    Course c1;
    Course c2;
    Course c3;

    String name;
    String stdNo;
    String classes;
    double average;
    boolean isPass;

    Student(String name, String stdNo, String classes, Course c1, Course c2,Course c3){
        this.name=name;
        this.stdNo=stdNo;
        this.classes=classes;
        this.c1=c1;
        this.c2=c2;
        this.c3=c3;
        this.average=0.0;
        this.isPass=false;
    }
    void addSozlu(int s1,int s2,int s3){
        this.c1.sozlu=s1;
        this.c2.sozlu=s2;
        this.c3.sozlu=s3;
    }

    void addExamNote(int note1,int note2,int note3){
        this.c1.note=note1;
        this.c2.note=note2;
        this.c3.note=note3;
    }

    void printNote(){
        System.out.println(c1.name + "Notu\t:" + c1.note);
        System.out.println(c2.name + "Notu\t:" + c2.note);
        System.out.println(c3.name + "Notu\t:" + c3.note);
    }

    void calcAverage(){
        this.average=(c1.note*0.8+c2.note*0.8+c3.note*0.8+c1.sozlu*0.2+c2.sozlu*0.2+c3.sozlu*0.2)/3.0;
        System.out.println(+ average);
    }

    void isPass(){
        if(this.average>55){
            System.out.println("Pass the class");
        }
        else{
            System.out.println("Study more!!");
        }
    }
}