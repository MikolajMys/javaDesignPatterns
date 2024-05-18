package facade;

interface iTicket {
    void setTime(String time);
    void setType(String type);
    String getDetails();
}

class NormalTicket implements iTicket {
    private String type;
    private String time;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String getDetails() {
        return "Normal Ticket - Type: " + type + ", Time: " + time;
    }
}

class DiscountedTicket implements iTicket {
    private String type;
    private String time;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String getDetails() {
        return "Discounted Ticket - Type: " + type + ", Time: " + time;
    }
}

class BusTicketFacade {
    private iTicket activeTicket;

    public void buyTicket(String type, String time) {
        switch (type.toLowerCase()) {
            case "normal":
                activeTicket = new NormalTicket();
                break;
            case "discounted":
                activeTicket = new DiscountedTicket();
                break;
            default:
                throw new IllegalArgumentException("Unknown ticket type: " + type);
        }
        activeTicket.setType(type);
        activeTicket.setTime(time);
        System.out.println("Ticket purchased: " + activeTicket.getDetails());
    }

    public void showActiveTicket() {
        if (activeTicket != null) {
            System.out.println("Active Ticket: " + activeTicket.getDetails());
        } else {
            System.out.println("No active ticket.");
        }
    }
}

class Client {
    BusTicketFacade facade = new BusTicketFacade();
    void performAction() {
        facade.buyTicket("normal", "1h");
        //facade.showActiveTicket();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
