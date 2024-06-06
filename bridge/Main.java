package bridge;

interface GamingPlatform {
    public void startGame();
    public void saveGame();
    public void endGame();
}

class PC implements GamingPlatform {
    @Override
    public void startGame() {
        System.out.println("Game is running");
    }
    @Override
    public void saveGame() {
        System.out.println("Game saved");
    }
    @Override
    public void endGame() {
        System.out.println("Closing game");
    }
}

class PS3 implements GamingPlatform {
    @Override
    public void startGame() {
        System.out.println("Game is running");
    }
    @Override
    public void saveGame() {
        System.out.println("Game saved");
    }
    @Override
    public void endGame() {
        System.out.println("Closing game");
    }
    public void enterMainHub() {
        System.out.println("Navigating through the MainHub");
    }
}

abstract class Gamepad {
    protected GamingPlatform gamingPlatform;

    public Gamepad(GamingPlatform gamingPlatform) {
        this.gamingPlatform = gamingPlatform;
    }

    public void pressToStart() {
        gamingPlatform.startGame();
    }
    public void pressToSave() {
        gamingPlatform.saveGame();
    }
    public void pressToEnd() {
        gamingPlatform.endGame();
    }
}

class PCGamepad extends Gamepad {
    public PCGamepad(GamingPlatform gamingPlatform) {
        super(gamingPlatform);
    }
}

class PS3Gamepad extends Gamepad {
    public PS3Gamepad(GamingPlatform gamingPlatform) {
        super(gamingPlatform);
    }

    public void navigateOnMainHub() {
        if (gamingPlatform instanceof PS3) {
            ((PS3) gamingPlatform).enterMainHub();
        }
    }
}

class Client {
    void performAction() {
        Gamepad ps3Gamepad = new PS3Gamepad(new PS3());
        ps3Gamepad.pressToStart();
        ((PS3Gamepad) ps3Gamepad).navigateOnMainHub();
        ps3Gamepad.pressToSave();
        ps3Gamepad.pressToEnd();

        Gamepad pcGamepad = new PCGamepad(new PC());
        pcGamepad.pressToStart();
        pcGamepad.pressToSave();
        pcGamepad.pressToEnd();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
