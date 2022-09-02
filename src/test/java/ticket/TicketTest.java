package ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketTest {

    Ticket ticket1 = new Ticket(1, 100, "LED", "DME", 95);
    Ticket ticket2 = new Ticket(2, 150, "SVO", "LED", 85);
    Ticket ticket3 = new Ticket(3, 250, "LED", "DME", 105);
    Ticket ticket4 = new Ticket(4, 150, "LED", "SVO", 95);

    @Test
    public void Sort() {

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket3};

        Arrays.sort(tickets);
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);
    }


}
