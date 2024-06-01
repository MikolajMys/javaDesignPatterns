package mediator;

import java.util.ArrayList;

class Button {
    public String onClick;

    public Button(String ocClick) {
        this.onClick = ocClick;
    }
}

class Gui {
    private ArrayList<Button> buttons = new ArrayList<>();

    public void addButon(Button button) {
        buttons.add(button);
    }
     public Button getButton(Button button) {
        Button find = new Button("");
        for(Button button_i : buttons) {
            if(button_i == button) {
                find = button_i;
            }
        }
        return find;
     }
}

class GuiMediator {
    private Gui guiMediatored;

    public GuiMediator(Gui gui) {
        this.guiMediatored = gui;
    }

    public void press(Button button) {
        Button onAction = guiMediatored.getButton(button);
        System.out.println(onAction.onClick);
    }
}

class Mouse {
    private Button clicked;

    public void click(Button button) {
        this.clicked = button;
    }

    public void comunicate(GuiMediator guiMediator) {
        guiMediator.press(clicked);
    }
}

class Client {
    void performAction() {
        Button btn1 = new Button("Hello!");
        Button btn2 = new Button("Goodbye!");

        Gui gui = new Gui();
        gui.addButon(btn1);
        gui.addButon(btn2);

        GuiMediator guiMediator = new GuiMediator(gui);

        Mouse mouse = new Mouse();
        mouse.click(btn1);
        mouse.comunicate(guiMediator);
        mouse.click(btn2);
        mouse.comunicate(guiMediator);
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
