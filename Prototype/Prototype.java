class Car implements Cloneable {
    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Prototype {
    public static void main(String[] args) {
        try {
            Car originalCar = new Car("Model S", "Red");
            System.out.println("Original Car: " + originalCar);

            Car clonedCar = (Car) originalCar.clone();
            clonedCar.setColor("Blue"); // Changing color of the cloned car
            System.out.println("Cloned Car: " + clonedCar);

            Car anotherClonedCar = (Car) originalCar.clone();
            anotherClonedCar.setModel("Model 3"); // Changing model of the cloned car

            System.out.println();
            System.out.println("Another cloned car: " + anotherClonedCar);
            System.out.println("Original Car: " + originalCar);
            System.out.println("Cloned Car: " + clonedCar);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
