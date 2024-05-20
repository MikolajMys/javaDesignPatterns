package factory_method;

interface Factory {
    public Car produce();
}

interface Car {
    public String showInfo();
}

class BMW implements Car{
    @Override
    public String showInfo() {
        return "BMW M4 Competition Coupé 2024r";
    }
}
class Audi implements Car {
    @Override
    public String showInfo() {
        return "Audi a3 8l 1.8t quattro 2002r";
    }
}
class Mercedes implements Car {
    @Override
    public String showInfo() {
        return "Mercedes-Benz Klasa G 2020r";
    }
}

class BMWFactory implements Factory {
    @Override
    public Car produce(){
        return new BMW();
    }
}

class AudiFactory implements Factory {
    @Override
    public Car produce(){
        return new Audi();
    }
}

class MercedesFactory implements Factory {
    @Override
    public Car produce(){
        return new Mercedes();
    }
}

class Client {
    public Car buyCar(Factory factory) {
        return factory.produce();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        Factory bmwFactory = new BMWFactory();
        Factory audiFactory = new AudiFactory();
        Factory mercedesFactory = new MercedesFactory();

        Car bmw = client.buyCar(bmwFactory);
        System.out.println("Client bought: " + bmw.showInfo());

        Car audi = client.buyCar(audiFactory);
        System.out.println("Client bought: " + audi.showInfo());

        Car mercedes = client.buyCar(mercedesFactory);
        System.out.println("Client bought: " + mercedes.showInfo());
    }
}