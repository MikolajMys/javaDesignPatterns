package command;

import java.util.ArrayDeque;
import java.util.Queue;

interface Command {
    public void execute();
}

class TurnOnAc implements Command {
    @Override
    public void execute() {
        System.out.println("AC IS ON");
    }
}

class TurnOnHeater implements Command {
    @Override
    public void execute() {
        System.out.println("HEATER IS ON");
    }
}

class TurnOnRadio implements Command {
    @Override
    public void execute() {
        System.out.println("RADIO IS ON");
    }
}

class SmartCarSystem {
    private Queue<Command> commands = new ArrayDeque<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void useCommands() {
        while(!commands.isEmpty()) {
            Command command = commands.poll();
            command.execute();
        }
    }
}

class Client {
    void performAction() {
        Command turnOnAc = new TurnOnAc();
        Command turnOnHeater = new TurnOnHeater();
        Command turnOnRadio = new TurnOnRadio();
        SmartCarSystem smartCarSystem = new SmartCarSystem();
        smartCarSystem.addCommand(turnOnAc);
        smartCarSystem.addCommand(turnOnRadio);
        smartCarSystem.useCommands();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}