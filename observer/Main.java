package observer;
import java.util.ArrayList;
import java.util.List;

interface TempObserver {
    void update(float temp);
}

interface TempWatched {
    void addObserver(TempObserver observer);
    void removeObserver(TempObserver observer);
    void setTemp(float temp);
    void notifyObservers();
}

class TempSensor implements TempWatched {
    private List<TempObserver> observers = new ArrayList<>();
    private float temp;

    @Override
    public void addObserver(TempObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TempObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void setTemp(float temp) {
        this.temp = temp;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (TempObserver observer : observers) {
            observer.update(temp);
        }
    }
}

class AlarmSystem implements TempObserver {
    private float max_temp;

    public AlarmSystem(float max_temp) {
        this.max_temp = max_temp;
    }

    @Override
    public void update(float temp) {
        if (temp > max_temp) {
            System.out.println("!!!ALARM TEMPERATURE TOO HIGH!!!: " + temp);
        }
    }
}

class Display implements TempObserver {
    @Override
    public void update(float temp) {
        System.out.println("Current temperature: " + temp);
    }
}


class Client {
    void performAction() {
        TempSensor sensor = new TempSensor();
        AlarmSystem alarm = new AlarmSystem(30.0f);
        Display display = new Display();

        sensor.addObserver(alarm);
        sensor.addObserver(display);

        System.out.println("Setting temperature to 25.0");
        sensor.setTemp(25.0f);

        System.out.println("\nSetting temperature to 35.0");
        sensor.setTemp(35.0f);
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
