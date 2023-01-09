public class Main {
    public static void main(String[] args) {
        Printer p=new CanonOffice(); //upcasting
        ((CanonOffice)p).fax(); //downcasting = ((Fax)p).fax();

        if(p instanceof Scan)
            ((CanonOffice) p).scan();
    }
}

interface Print {
    void print();
}


interface PrintColored{
    void color();
}

interface Fax{
    void fax();
}

interface Scan{
    void scan();
}
class Printer implements Print{
    @Override
    public void print() {
        System.out.println("basic printer");
    }
}

class CanonProfessional extends Printer implements PrintColored,Fax,Scan{

    @Override
    public void color() {
        System.out.println("canonpro can printed color");
    }

    @Override
    public void fax() {
        System.out.println("canonpro can fax");
    }

    @Override
    public void scan() {
        System.out.println("canon pro can scan ");
    }

    @Override
    public void print() {
        System.out.println("canon pro can print");
    }
}
class CanonOffice extends Printer implements Fax,Scan{

    @Override
    public void fax() {
        System.out.println("canon office can fax");
    }

    @Override
    public void scan() {
        System.out.println("canon office can scan ");
    }

    @Override
    public void print() {
        System.out.println("canon office can print");
    }
}
class CanonBasic extends Printer implements Scan {
    @Override
    public void scan() {
        System.out.println("Canon basic can scan");
    }

    @Override
    public void print() {
        System.out.println("canon basic can print");
    }
}

