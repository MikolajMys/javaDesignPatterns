package visitor;

interface PhoneCall {
    void accept(Visitor visitor);
}

class RedBtn implements PhoneCall {
    @Override
    public void accept(Visitor visitor) {
        visitor.cancelCall(this);
    }

    public String operationRed() {
        return "Cancel Call";
    }
}

class GreenBtn implements PhoneCall {
    @Override
    public void accept(Visitor visitor) {
        visitor.acceptCall(this);
    }

    public String operationGreen() {
        return "Accept Call";
    }
}

interface Visitor {
    public void cancelCall(RedBtn redBtn);
    public void acceptCall(GreenBtn greenBtn);
}

class PhoneCallVisitor implements Visitor {
    @Override
    public void cancelCall(RedBtn redBtn) {
        System.out.println("PhoneCall: " + redBtn.operationRed());
    }
    @Override
    public void acceptCall(GreenBtn greenBtn) {
        System.out.println("PhoneCall: " + greenBtn.operationGreen());
    }
}

class Client {
    void performAction() {
        Visitor visitor = new PhoneCallVisitor();
        RedBtn redBtn = new RedBtn();
        GreenBtn greenBtn = new GreenBtn();
        redBtn.accept(visitor);
        greenBtn.accept(visitor);
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
