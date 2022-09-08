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
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getItems()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        if (result.length == 0) {
            throw new NotFoundException("Element with id: " + from + " not found");
        } else {
            Arrays.sort(result);
            return result;
        }
    }
    public Ticket[] findFast(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = findByDepArr(from, to);
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        return (ticket.getDeparture().equals(from) && ticket.getArrived().equals(to));
    }
}

