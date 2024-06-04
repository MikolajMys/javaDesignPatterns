package builder;

interface Builder {
    public void takeData(String data);
    public void generate();
    public void produce();
}

class ModelGenerator3d implements Builder {
    private String productData = "";

    @Override
    public void takeData(String data) {
        System.out.println("Processing the: " + data);
    }
    @Override
    public void generate() {
        System.out.println("Generating product...");
        productData = "Job done succesfully!";
    }
    @Override
    public void produce() {
        System.out.println(productData);
    }
}

class ModelPrinter3d implements Builder {
    private String productData = "";

    @Override
    public void takeData(String data) {
        System.out.println("Processing the: " + data + " 3d model");
    }
    @Override
    public void generate() {
        System.out.println("Generating product on canvas...");
        productData = "3d model printed succesfully!";
    }
    @Override
    public void produce() {
        System.out.println(productData);
    }
}

class Controller {
    public void build(Builder builder){
        builder.takeData("little ship");
        builder.generate();
        builder.produce();
    }
}

class Client {
    void performAction() {
        ModelGenerator3d generator3d = new ModelGenerator3d();
        ModelPrinter3d printer3d = new ModelPrinter3d();

        Controller controller = new Controller();
        controller.build(generator3d);
        controller.build(printer3d);
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}