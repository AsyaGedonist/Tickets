package ticket;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void saveManager(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll() {
        return repo.getItems();
    }

    public Ticket[] findByDepArr(String from, String to) {
        repo.findByDep(from);
        Ticket[] tickets = repo.findByArr(to);
        Arrays.sort(tickets);
        return tickets;
    }
    public Ticket[] findFast(String from, String to, Comparator<Ticket> comparator) {
        repo.findByDep(from);
        Ticket[] tickets = repo.findByArr(to);
        Arrays.sort(tickets, comparator);
        return tickets;
    }
}

