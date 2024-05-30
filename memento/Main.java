package memento;

class CodeEditor {
    private String code = "";

    public void saveCode(String code){
        this.code = code;
    }

    public void deleteCode() {
        this.code = "";
    }

    public String getCode() {
        return code;
    }

    public Memento createMemento() {
        return new Memento(code);
    }

    public void restoreMemento(Memento memento) {
        code = memento.getCode();
    }
}

class Memento {
    private String code;

    public Memento(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

class Client {
    void performAction() {
        CodeEditor kate = new CodeEditor();
        kate.saveCode("std::cout<<a<<std::endl;");
        Memento save1 = kate.createMemento();
        kate.saveCode("printf('%d', a);");
        System.out.println("Now: "+kate.getCode());
        kate.restoreMemento(save1);
        System.out.println("Before: "+kate.getCode());
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}