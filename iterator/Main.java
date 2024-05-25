package iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

interface Iterator {
    public boolean hasNext();
    public Delivery next();
}

class DeliveryIterator implements Iterator {
    private DeliverySystem deliverySystem;
    private int deliveryIndex;

    public DeliveryIterator(DeliverySystem deliverySystem) {
        this.deliverySystem = deliverySystem;
        this.deliveryIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return deliveryIndex < deliverySystem.getDeliveries().size();
    }

    @Override
    public Delivery next() {
        if(hasNext()) {
            return deliverySystem.getDeliveries().get(deliveryIndex++);
        }
        throw new NoSuchElementException("No more elements to iterate over.");
    }
}

class DeliverySystem {
    private ArrayList<Delivery> deliveries = new ArrayList<>();

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    public void removeDelivery(Delivery delivery) {
        deliveries.remove(delivery);
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }
}

class Delivery {
    private String date;
    private String initialDestination;
    private String finalDestination;

    public Delivery (String date, String initialDestination, String finalDestination) {
        this.date = date;
        this.initialDestination = initialDestination;
        this.finalDestination = finalDestination;
    }
    public void showInfo() {
        System.out.println("Delivery from " + initialDestination + " to " + finalDestination + " on " + date);
    }
}

class Client {
    void performAction() {
        DeliverySystem deliverySystem = new DeliverySystem();

        Delivery delivery1 = new Delivery("2024-05-27", "New York", "Los Angeles");
        Delivery delivery2 = new Delivery("2024-05-24", "Los Angeles", "Chicago");
        Delivery delivery3 = new Delivery("2024-05-25", "Chicago", "New York");

        deliverySystem.addDelivery(delivery1);
        deliverySystem.addDelivery(delivery2);
        deliverySystem.addDelivery(delivery3);

        DeliveryIterator iterator = new DeliveryIterator(deliverySystem);

        while (iterator.hasNext()) {
            Delivery delivery = iterator.next();
            delivery.showInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}