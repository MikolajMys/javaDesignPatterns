package flyweight;

import java.util.ArrayList;
import java.util.HashMap;

class DeliveryInfo {
    private String deliveryInfo;

    public DeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }
}

class Register {
    private HashMap<String, DeliveryInfo> deliveries = new HashMap<>();

    public DeliveryInfo check(String deliveryInfo) {
        if (!deliveries.containsKey(deliveryInfo)) {
            deliveries.put(deliveryInfo, new DeliveryInfo(deliveryInfo));
        }
        return deliveries.get(deliveryInfo);
    }

    public int number() {
        return deliveries.size();
    }
}

class PlaceDelivery {
    private int id;
    private DeliveryInfo deliveryInfo;

    public PlaceDelivery(int id, DeliveryInfo deliveryInfo) {
        this.id = id;
        this.deliveryInfo = deliveryInfo;
    }

    public void processDelivery() {
        System.out.println("processing");
    }
}

class DeliverySystem {
    private Register register = new Register();
    private ArrayList<PlaceDelivery> placeDeliveries = new ArrayList<>();

    public void placeDelivery(int id, String deliveryInfo) {
        DeliveryInfo dInfo = register.check(deliveryInfo);
        PlaceDelivery placeDelivery = new PlaceDelivery(id, dInfo);
        placeDeliveries.add(placeDelivery);
    }

    public void processAll() {
        for (PlaceDelivery placeDelivery : placeDeliveries) {
            placeDelivery.processDelivery();
        }
    }

    public void report() {
        System.out.println(register.number());
    }
}

class Client {
    void performAction() {
        DeliverySystem deliverySystem = new DeliverySystem();
        deliverySystem.placeDelivery(1, "Polska-Szwecja");
        deliverySystem.placeDelivery(2, "Szwecja-Niemcy");
        deliverySystem.processAll();
        deliverySystem.report();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
