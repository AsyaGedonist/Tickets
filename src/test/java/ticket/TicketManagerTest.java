package ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 100, "LED", "DME", 95);
    Ticket ticket2 = new Ticket(2, 250, "LED", "DME", 85);
    Ticket ticket3 = new Ticket(3, 150, "LED", "DME", 105);
    Ticket ticket4 = new Ticket(4, 150, "LED", "SVO", 95);
    Ticket ticket5 = new Ticket(5, 350, "LED", "SVO", 105);
    Ticket ticket6 = new Ticket(6, 250, "LED", "SVO", 85);
    Ticket ticket7 = new Ticket(7, 100, "DME", "SVO", 95);
    Ticket ticket8 = new Ticket(8, 150, "DME", "LED", 85);
    Ticket ticket9 = new Ticket(9, 250, "DME", "LED", 105);
    Ticket ticket10 = new Ticket(10, 150, "SVO", "LED", 95);
    Ticket ticket11 = new Ticket(11, 150, "SVO", "LED", 105);
    Ticket ticket12 = new Ticket(12, 250, "SVO", "LED", 85);

    @BeforeEach
    public void setup() {
        manager.saveManager(ticket1);
        manager.saveManager(ticket2);
        manager.saveManager(ticket3);
        manager.saveManager(ticket4);
        manager.saveManager(ticket5);
        manager.saveManager(ticket6);
        manager.saveManager(ticket7);
        manager.saveManager(ticket8);
        manager.saveManager(ticket9);
        manager.saveManager(ticket10);
        manager.saveManager(ticket11);
        manager.saveManager(ticket12);
    }

    @Test
    public void ShouldViewAll() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10, ticket11, ticket12};
        Ticket[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFind() {
        Ticket[] expected = {ticket4, ticket6, ticket5};
        Ticket[] actual = manager.findByDepArr("LED", "SVO");
    }

   @Test
    public void NoDep() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.findByDepArr("OOO", "SVO");
        });
    }
    @Test
    public void NoArr() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.findByDepArr("LED", "OOO");
        });
    }
}
