package abstract_factory;

interface AbstractFactory {
    public BodyPanels produceBodyPanels();
    public Interior produceInterior();
    public Windshields produceWindshields();
}

interface BodyPanels {
    public String showInfo();
}
interface Interior {
    public String showInfo();
}
interface Windshields {
    public String showInfo();
}

class BMWBodyPanels implements BodyPanels {
    @Override
    public String showInfo() {
        return "BMW M4 Competition Coupé 2024r panels";
    }
}
class AudiBodyPanels implements BodyPanels {
    @Override
    public String showInfo() {
        return "Audi a3 8l 1.8t quattro 2002r panels";
    }
}
class MercedesBodyPanels implements BodyPanels {
    @Override
    public String showInfo() {
        return "Mercedes-Benz Klasa G 2020r panels";
    }
}
class BMWInterior implements Interior {
    @Override
    public String showInfo() {
        return "BMW M4 Competition Coupé 2024r interior";
    }
}
class AudiInterior implements Interior {
    @Override
    public String showInfo() {
        return "Audi a3 8l 1.8t quattro 2002r interior";
    }
}
class MercedesInterior implements Interior {
    @Override
    public String showInfo() {
        return "Mercedes-Benz Klasa G 2020r interior";
    }
}
class BMWWindshields implements Windshields {
    @Override
    public String showInfo() {
        return "BMW M4 Competition Coupé 2024r windshields";
    }
}
class AudiWindshields implements Windshields {
    @Override
    public String showInfo() {
        return "Audi a3 8l 1.8t quattro 2002r windshields";
    }
}
class MercedesWindshields implements Windshields {
    @Override
    public String showInfo() {
        return "Mercedes-Benz Klasa G 2020r windshields";
    }
}

class BMWFactory implements AbstractFactory {
    @Override
    public BodyPanels produceBodyPanels() {
        return new BMWBodyPanels();
    }
    @Override
    public Interior produceInterior() {
        return new BMWInterior();
    }
    @Override
    public Windshields produceWindshields() {
        return new BMWWindshields();
    }
}

class AudiFactory implements AbstractFactory {
    @Override
    public BodyPanels produceBodyPanels() {
        return new AudiBodyPanels();
    }
    @Override
    public Interior produceInterior() {
        return new AudiInterior();
    }
    @Override
    public Windshields produceWindshields() {
        return new AudiWindshields();
    }
}

class MercedesFactory implements AbstractFactory {
    @Override
    public BodyPanels produceBodyPanels() {
        return new MercedesBodyPanels();
    }
    @Override
    public Interior produceInterior() {
        return new MercedesInterior();
    }
    @Override
    public Windshields produceWindshields() {
        return new MercedesWindshields();
    }
}

class Client {
    public BodyPanels makeBodyPanels(AbstractFactory factory) {
        return factory.produceBodyPanels();
    }
    public Interior makeInterior(AbstractFactory factory) {
        return factory.produceInterior();
    }
    public Windshields makeWindshields(AbstractFactory factory) {
        return factory.produceWindshields();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        AbstractFactory bmwFactory = new BMWFactory();
        AbstractFactory audiFactory = new AudiFactory();
        AbstractFactory mercedesFactory = new MercedesFactory();

        BodyPanels bmwBodyPanel = client.makeBodyPanels(bmwFactory);
        Interior bmwInterior = client.makeInterior(bmwFactory);
        Windshields bmwWindshield = client.makeWindshields(bmwFactory);
        System.out.println("Client make: " + bmwBodyPanel.showInfo());
        System.out.println("Client make: " + bmwInterior.showInfo());
        System.out.println("Client make: " + bmwWindshield.showInfo());

        BodyPanels audiBodyPanel = client.makeBodyPanels(audiFactory);
        Interior audiInterior = client.makeInterior(audiFactory);
        Windshields audiWindshield = client.makeWindshields(audiFactory);
        System.out.println("Client make: " + audiBodyPanel.showInfo());
        System.out.println("Client make: " + audiInterior.showInfo());
        System.out.println("Client make: " + audiWindshield.showInfo());

        BodyPanels mercedesBodyPanel = client.makeBodyPanels(mercedesFactory);
        Interior mercedesInterior = client.makeInterior(mercedesFactory);
        Windshields mercedesWindshield = client.makeWindshields(mercedesFactory);
        System.out.println("Client make: " + mercedesBodyPanel.showInfo());
        System.out.println("Client make: " + mercedesInterior.showInfo());
        System.out.println("Client make: " + mercedesWindshield.showInfo());
    }
}