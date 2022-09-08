package ticket;

public class TicketRepository {

    public Ticket[] tickets = new Ticket[0];

    public TicketRepository() {
    }

    public void save(Ticket ticket) {
        int haveId = 0;
        for (Ticket tick : tickets) {
            if (ticket.getId() != tick.getId()) {
                continue;
            } else {
                haveId++;
            }
        }
        if (haveId == 0) {
            Ticket[] tmp = new Ticket[tickets.length + 1];
            for (int i = 0; i < tickets.length; i++) {
                tmp[i] = tickets[i];
            }
            tmp[tmp.length - 1] = ticket;
            tickets = tmp;
        } else {
            throw new AlreadyExistsException("Element with id: " + ticket.getId() + " is already exist");
        }
    }

    public Ticket[] getItems() {
        return tickets;
    }

    public Ticket[] removeById(int id) {
        Ticket pr = null;
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                pr = ticket;
            }
        }
        if (pr == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int copyToIndex = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getId() != id) {
                    tmp[copyToIndex] = ticket;
                    copyToIndex++;
                }
            }
            tickets = tmp;
            return tickets;
        }
    }
}
