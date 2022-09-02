package ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 100, "LED", "DME", 95);
    Ticket ticket2 = new Ticket(2, 250, "SVO", "LED", 85);
    Ticket ticket3 = new Ticket(3, 150, "LED", "DME", 105);
    Ticket ticket4 = new Ticket(4, 150, "LED", "SVO", 95);

    @Test
    public void shouldDel() {

        TicketRepository tickets = new TicketRepository();

        Ticket[] expected = {ticket1, ticket2, ticket4};

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);
        tickets.removeById(3);
        Ticket[] actual = tickets.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDel() {

        TicketRepository tickets = new TicketRepository();

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tickets.removeById(5);
        });
    }

    @Test
    public void shouldAdd() {

        TicketRepository tickets = new TicketRepository();

        Ticket[] expected = {ticket1};

        tickets.save(ticket1);

        Ticket[] actual = tickets.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAdd() {

        TicketRepository tickets = new TicketRepository();

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            tickets.save(ticket2);
        });
    }

    @Test
    public void shouldRemove() {

        TicketRepository tickets = new TicketRepository();

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = tickets.removeById(2);

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotRemove() {

        TicketRepository tickets = new TicketRepository();

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tickets.removeById(5);
        });
    }

    @Test
    public void ShouldViewLED() {
        TicketRepository tickets = new TicketRepository();
        Ticket[] expected = {ticket1, ticket3, ticket4};

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);

        Ticket[] actual = tickets.findByDep("LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldViewDME() {
        TicketRepository tickets = new TicketRepository();
        Ticket[] expected = {ticket1, ticket3};

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);

        Ticket[] actual = tickets.findByArr("DME");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NoDep() {
        TicketRepository tickets = new TicketRepository();

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tickets.findByDep("OOO");
        });
    }

    @Test
    public void NoArr() {
        TicketRepository tickets = new TicketRepository();

        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tickets.findByArr("OOO");
        });
    }
}
