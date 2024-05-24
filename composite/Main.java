package composite;

import java.util.ArrayList;
import java.util.List;

interface CssObject {
    public abstract void showData();
}

class CssObjectComposite {
    private ArrayList<CssObject> composite = new ArrayList<>();
    public void addCssObject(CssObject cssObject){
        this.composite.add(cssObject);
    }
    public void removeCssObject(CssObject cssObject){
        this.composite.remove(cssObject);
    }
    public void showData(){
        for(CssObject cssObject : composite){
            cssObject.showData();
        }
    }
}

class Button implements CssObject {
    private String data;

    public Button(String data) {
        this.data = data;
    }

    @Override
    public void showData() {
        System.out.println(this.data);
    }
}
class Input implements CssObject {
    private String data;

    public Input(String data) {
        this.data = data;
    }

    @Override
    public void showData() {
        System.out.println(this.data);
    }
}
class Client {
    void performAction() {
        CssObjectComposite composite = new CssObjectComposite();

        Button button = new Button("color: red;");
        Input input = new Input("background-color: blue;");

        composite.addCssObject(button);
        composite.addCssObject(input);

        composite.showData();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}