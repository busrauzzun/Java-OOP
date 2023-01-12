import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        Book b1=new Book("B",2.2);
        Book b2=new Book("A",5.7);
        Book b3=new Book("D",14.1);
        Book b4=new Book("K",8.8);

        LinkedList <Book> list= new LinkedList<Book>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);


        System.out.println(list);

        System.out.println("siralandiktan sonra");

        Collections.sort(list);

        //System.out.println(list);

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }

        System.out.println("------");
    }
}

class Book implements Comparable <Book> {
    String name;
    double price;

    Book(String name,double price){
        this.name=name;
        this.price=price;
    }

    double totalPrice(){
        double total=  price+ price*0.8;
        return total;
    }

    @Override
    public int compareTo(Book other){
        if(this.totalPrice()- other.totalPrice()>1)
            return 1;
        else if(this.totalPrice()- other.totalPrice()<1)
            return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "name=" + name +" " + "price=" + price;
    }
}
