package template_method;

abstract class PrintSystem {
    protected String text = "";

    public void addText(String text) {
        this.text = text;
    }

    public void deleteText() {
        this.text = "";
    }

    abstract void print();
}

class PrintNormal extends PrintSystem {
    @Override
    void print() {
        System.out.println(text);
    }
}

class PrintBackward extends PrintSystem {
    @Override
    void print() {
        for(int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }
        System.out.println();
    }
}

class Client {
    void performAction() {
        PrintSystem printNormal = new PrintNormal();
        printNormal.addText("Hello, World!");
        printNormal.print();

        PrintSystem printBackward = new PrintBackward();
        printBackward.addText("Hello, World!");
        printBackward.print();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}