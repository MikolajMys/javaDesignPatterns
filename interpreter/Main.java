package interpreter;

interface Bmi {
    public float result();
}

class Constant implements Bmi {
    private float value;

    public Constant(float value) {
        this.value = value;
    }

    @Override
    public float result() {
        return value;
    }
}

class CalculateBmi implements Bmi {
    private Constant weight;
    private Constant height;

    public CalculateBmi(Constant weight, Constant height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public float result() {
        float tempW = weight.result();
        float tempH = height.result();

        return tempW/(tempH*tempH);
    }
}

class Client {
    void performAction() {
        Constant weight = new Constant(82.0f);
        Constant height = new Constant(1.8f);

        CalculateBmi myBmi = new CalculateBmi(weight, height);
        float res = myBmi.result();
        if(res < 18.5f) {
            System.out.println("Niedowaga");
        } else if(res >= 18.5f && res <= 24.9f) {
            System.out.println("Pożądana masa ciała");
        } else if(res >= 25.0f && res <= 29.9f) {
            System.out.println("Nadwaga");
        } else if(res >= 30.0f) {
            System.out.println("Otyłość");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}