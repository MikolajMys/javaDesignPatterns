package prototype;
abstract class CssObject {
    protected String data;
    public CssObject(String data) {
        this.data = data;
    }
    public abstract void showData();
    public abstract CssObject clone();
}

class Button extends CssObject {
    public Button(String data) {
        super(data);
    }

    @Override
    public void showData() {
        System.out.println(this.data);
    }

    @Override
    public Button clone() {
        return new Button(this.data);
    }
}
class Input extends CssObject {
    public Input(String data) {
        super(data);
    }

    @Override
    public void showData() {
        System.out.println(this.data);
    }

    @Override
    public Input clone() {
        return new Input(this.data);
    }
}
class Client {
    void performAction() {
        Button button = new Button("color: red;");
        Button clonedButton = button.clone();

        Input input = new Input("background-color: blue;");
        Input clonedInput = input.clone();

        System.out.println("Original and cloned Button data:");
        button.showData();
        clonedButton.showData();

        System.out.println("Original and cloned Input data:");
        input.showData();
        clonedInput.showData();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}