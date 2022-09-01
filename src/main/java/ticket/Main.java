package ticket;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket(1, 100, "LED", "DME", 95);
        Ticket ticket2 = new Ticket(2, 250, "LED", "DME", 85);
        Ticket ticket3 = new Ticket(3, 150, "LED", "DME", 105);
        Ticket ticket4 = new Ticket(4, 150, "LED", "SVO", 95);
        Ticket ticket5 = new Ticket(5, 150, "LED", "SVO", 105);
        Ticket ticket6 = new Ticket(6, 250, "LED", "SVO", 85);
        Ticket ticket7 = new Ticket(7, 100, "DME", "LED", 95);
        Ticket ticket8 = new Ticket(8, 150, "DME", "LED", 85);
        Ticket ticket9 = new Ticket(9, 250, "DME", "LED", 105);
        Ticket ticket10 = new Ticket(10, 150, "SVO", "LED", 95);
        Ticket ticket11 = new Ticket(11, 150, "SVO", "LED", 105);
        Ticket ticket12 = new Ticket(12, 250, "SVO", "LED", 85);

        System.out.println(ticket1.compareTo(ticket2));
        System.out.println(ticket2.compareTo(ticket1));

        Ticket[] tickets = {ticket1, ticket2, ticket3};

        Arrays.sort(tickets);

    }
}
