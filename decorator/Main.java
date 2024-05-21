package decorator;

interface GUIComponents {
    String showData();
}

class Button implements GUIComponents{
    @Override
    public String showData() {
        return "<Button>";
    }
}

abstract class ComponentsDecorator implements GUIComponents{
    protected GUIComponents guiComponent;

    public ComponentsDecorator(GUIComponents guiComponent) {
        this.guiComponent = guiComponent;
    }

    @Override
    public String showData() {
        return guiComponent.showData();
    }
}

class ColorDecorator extends ComponentsDecorator {
    private String color;

    public ColorDecorator(GUIComponents guiComponent, String color) {
        super(guiComponent);
        this.color = color;
    }

    @Override
    public String showData() {
        return guiComponent.showData() + color;
    }
}

class BorderDecorator extends ComponentsDecorator {
    private String border;

    public BorderDecorator(GUIComponents guiComponent, String border) {
        super(guiComponent);
        this.border = border;
    }

    @Override
    public String showData() {
        return guiComponent.showData() + border;
    }
}

class Client {
    void performAction() {
        GUIComponents button = new Button();

        GUIComponents colorButton = new ColorDecorator(button, "<Color:#000000>");

        GUIComponents borderButton = new BorderDecorator(colorButton, "<Border:1px solid>");

        System.out.println(button.showData());
        System.out.println(colorButton.showData());
        System.out.println(borderButton.showData());
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
