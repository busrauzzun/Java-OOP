import java.util.*;

public class Main {
    public static void main(String[] args) {

        Ticket t1 = new StandartTicket(10, 1);
        Ticket t2 = new DiscountTicket(22, 2, 0.1);
        Ticket t3 = new DiscountTicket(12, 3, 0.2);
        Ticket t4 = new StandartTicket(35, 4);

        List <Ticket> tickets=new LinkedList<>() ;
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);

        sortandPrint(tickets);

        TicketSeller ticketseller =new TicketSeller(tickets);

        ticketseller.sell(t1);
    }
    static  void  sortandPrint(List <Ticket> tickets){
        SeatNumberComparator snc=new SeatNumberComparator();
        Collections.sort(tickets,snc);

        Iterator<Ticket>itr=tickets.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}
abstract class Ticket {
    int number;
    int seatnumber;

    public Ticket(int number, int seatnumber) {
        this.number = number;
        this.seatnumber = seatnumber;
    }

    abstract void print();
    abstract double computePrice();

    @Override
    public String toString() {
        return "Ticket" +
                "number=" + number +
                ", seatnumber=" + seatnumber ;
    }
}

class StandartTicket extends Ticket{
    double price=10.0;

    public StandartTicket(int number, int seatnumber) {
        super(number, seatnumber);
    }

    @Override
    void print(){
        System.out.println(seatnumber +" "+price +" " + number);
    }

    @Override
    double computePrice() {
        return price;
    }
}
class DiscountTicket extends StandartTicket{
    double discount;

    public DiscountTicket(int number, int seatnumber, double discount) {
        super(number, seatnumber);
        this.discount = discount;
    }
    @Override
    double computePrice() {
        return super.computePrice()-price*discount;
    }

    @Override
    public void print() {
        System.out.println(seatnumber +" "+price +" " + number + " " + discount);
    }
}

class TicketSeller {
    List <Ticket> tickets;
    private double incomes;

    public TicketSeller(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    void sell(Ticket ticket){
        incomes+= ticket.computePrice();
        tickets.remove(ticket);
    }

    double getincomes(){
        return incomes;
    }
}

public class SeatNumberComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1,Ticket t2){
        return t1.seatnumber-t2.seatnumber;
    }
}

