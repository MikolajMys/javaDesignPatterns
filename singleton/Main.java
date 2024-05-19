package singleton;

class Client {
    void performAction() {
        System.out.println("hello");
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}