package strategy;

interface Trailer {
    public String showInfo();
}

class RefrigeratedTrailer implements Trailer {
    private String info;

    public RefrigeratedTrailer(String info) {
        this.info = info;
    }

    @Override
    public String showInfo() {
        return info;
    }
}

class BoxTrailer implements Trailer {
    private String info;

    public BoxTrailer(String info) {
        this.info = info;
    }

    @Override
    public String showInfo() {
        return info;
    }
}

class Company {
    private Trailer trailer;

    public void setTrailer(Trailer trailer){
        this.trailer = trailer;
    }

    public void sendTruck() {
        System.out.println("Truck with" + trailer.showInfo());
    }
}

class Client {
    void performAction() {
        Company company = new Company();

        Trailer refrigeratedTrailer = new RefrigeratedTrailer(" a refrigerated trailer with allowed package 22 000 kg");
        company.setTrailer(refrigeratedTrailer);
        company.sendTruck();

        Trailer boxTrailer = new BoxTrailer(" a box trailer with allowed package 30,000 kg");
        company.setTrailer(boxTrailer);
        company.sendTruck();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}