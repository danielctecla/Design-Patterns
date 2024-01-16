interface AmericanSocket {
    void insertInAmericanSocket();
}

class EuropeanPlug {
    void insertInEuropeanSocket() {
        System.out.println("Plug inserted in European socket");
    }
}

class EuropeanToAmericanPlugAdapter implements AmericanSocket {
    private EuropeanPlug europeanPlug;

    public EuropeanToAmericanPlugAdapter(EuropeanPlug plug) {
        this.europeanPlug = plug;
    }

    @Override
    public void insertInAmericanSocket() {
        System.out.println("Adapter converts European plug to fit in American socket");
        europeanPlug.insertInEuropeanSocket();
    }
}

class AmericanPlug implements AmericanSocket {
    public void insertInAmericanSocket() {
        System.out.println("Plug inserted in American socket");
    }
}

public class Adapter {
    public static void main(String[] args) {
        AmericanPlug americanPlug = new AmericanPlug();
        americanPlug.insertInAmericanSocket();

        EuropeanPlug europeanPlug = new EuropeanPlug();
        
        AmericanSocket adapter = new EuropeanToAmericanPlugAdapter(europeanPlug);
        adapter.insertInAmericanSocket();
    }
}
