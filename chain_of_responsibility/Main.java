package chain_of_responsibility;

abstract class ErrCode {
    protected ErrCode next;

    public ErrCode(ErrCode next) {
        this.next = next;
    }

    public abstract void diagnose(String err);
}

class GeneralErr extends ErrCode {
    public GeneralErr() {
        super(null);
    }

    @Override
    public void diagnose(String err) {
        if(err == "g000") {
            System.out.println("General issue found!");
        } else {
            System.out.println("Can't diagnose by code!");
        }
    }
}

class SuspensionErr extends ErrCode {
    public SuspensionErr() {
        super(new GeneralErr());
    }

    @Override
    public void diagnose(String err) {
        if(err == "s001") {
            System.out.println("Suspension issue found!");
        } else {
            next.diagnose(err);
        }
    }
}

class TransmissionErr extends ErrCode {
    public TransmissionErr() {
        super(new SuspensionErr());
    }

    @Override
    public void diagnose(String err) {
        if(err == "t002") {
            System.out.println("Transmission issue found!");
        } else {
            next.diagnose(err);
        }
    }
}

class EngineErr extends ErrCode {
    public EngineErr() {
        super(new TransmissionErr());
    }

    @Override
    public void diagnose(String err) {
        if(err == "e003") {
            System.out.println("Engine issue found!");
        } else {
            next.diagnose(err);
        }
    }
}

class OBD {
    private ErrCode errCode;

    public OBD() {
        this.errCode = new EngineErr();
    }

    public void diagnose(String err) {
        errCode.diagnose(err);
    }
}

class Client {
    void performAction() {
        OBD obd = new OBD();

        obd.diagnose("e003"); // Engine issue found!
        obd.diagnose("t002"); // Transmission issue found!
        obd.diagnose("s001"); // Suspension issue found!
        obd.diagnose("g000"); // General issue found!
        obd.diagnose("x999"); // Can't diagnose by code!
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}
