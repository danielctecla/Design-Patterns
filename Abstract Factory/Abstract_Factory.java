/* Interface for creating processors */
interface Processor {
  void process();
}

/* Concrete implementations of the Processor interface */
class IntelProcessor implements Processor {
  public void process() {
    System.out.println("Processing with an Intel processor.");
  }
}

class AMDProcessor implements Processor {
  public void process() {
    System.out.println("Processing with an AMD processor.");
  }
}

/* Interface for creating graphics cards */
interface GraphicsCard {
  void render();
}

/* Concrete implementations of the GraphicsCard interface */
class NvidiaGraphicsCard implements GraphicsCard {
  public void render() {
    System.out.println("Rendering with an Nvidia graphics card.");
  }
}

class AMDGraphicsCard implements GraphicsCard {
  public void render() {
    System.out.println("Rendering with an AMD graphics card.");
  }
}

/* Abstract interface for creating hardware component factories */
interface HardwareFactory {
  Processor createProcessor();
  GraphicsCard createGraphicsCard();
}

/* Concrete implementations of the HardwareFactory interface for Intel */
class IntelFactory implements HardwareFactory {
  public Processor createProcessor() {
    return new IntelProcessor();
  }

  public GraphicsCard createGraphicsCard() {
    return new NvidiaGraphicsCard();
  }
}

/* Concrete implementations of the HardwareFactory interface for AMD */
class AMDFactory implements HardwareFactory {
  public Processor createProcessor() {
    return new AMDProcessor();
  }

  public GraphicsCard createGraphicsCard() {
    return new AMDGraphicsCard();
  }
}

/* In operation */
public class Abstract_Factory {
  public static void main(String[] args) {
    HardwareFactory intelFactory = new IntelFactory();

    Processor intelProcessor = intelFactory.createProcessor();
    GraphicsCard intelGraphicsCard = intelFactory.createGraphicsCard();

    intelProcessor.process();
    intelGraphicsCard.render();

    System.out.println();

    HardwareFactory amdFactory = new AMDFactory();

    Processor amdProcessor = amdFactory.createProcessor();
    GraphicsCard amdGraphicsCard = amdFactory.createGraphicsCard();

    amdProcessor.process();
    amdGraphicsCard.render();
  }
}
