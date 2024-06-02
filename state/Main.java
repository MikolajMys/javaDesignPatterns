package state;

interface State {
    public void changeMaxSpeed();
}

class EScooter {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void showDetails() {
        state.changeMaxSpeed();
    }
}

class Eco implements State {
    @Override
    public void changeMaxSpeed() {
        System.out.println("Max speed: 15Mph");
    }
}

class Ride implements State {
    @Override
    public void changeMaxSpeed() {
        System.out.println("Max speed: 20Mph");
    }
}

class Sport implements State {
    @Override
    public void changeMaxSpeed() {
        System.out.println("Max speed: 25Mph");
    }
}

class Client {
    void performAction() {
        EScooter eScooter = new EScooter();
        Eco eco = new Eco();
        Ride ride = new Ride();
        Sport sport = new Sport();

        eScooter.setState(eco);
        eScooter.showDetails();

        eScooter.setState(sport);
        eScooter.showDetails();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}