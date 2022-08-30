package ticket;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected double price;
    protected String departure;
    protected String arrived;
    protected int minute;

    public Ticket(int id, double price, String departure, String arrived, int minute) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrived = arrived;
        this.minute = minute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price){
            return -1;
        } else if (this.price > o.price){
            return  1;
        } else {
            return 0;
        }
    }
}
