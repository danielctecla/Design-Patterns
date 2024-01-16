class Car {
    // Car attributes
    private String engine;
    private int wheels;
    private int airbags;
    private String color;
    private boolean airConditioning;
    private String carType;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.airbags = builder.airbags;
        this.color = builder.color;
        this.airConditioning = builder.airConditioning;
        this.carType = builder.carType;
    }

    public static class CarBuilder {
        private String engine;
        private int wheels;
        private int airbags;
        private String color;
        private boolean airConditioning;
        private String carType;

        public CarBuilder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public CarBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setAirConditioning(boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        public CarBuilder setCarType(String carType) {
            this.carType = carType;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public String getEngine() {
        return this.engine;
    }

    public int getWheels() {
        return this.wheels;
    }

    public int getAirbags() {
        return this.airbags;
    }

    public String getColor() {
        return this.color;
    }

    public boolean getAirConditioning() {
        return this.airConditioning;
    }

    public String getCarType() {
        return this.carType;
    }
}

public class Builder {
    public static void main(String[] args) {
        Car sportsCar = new Car.CarBuilder("V8 engine", 4)
                .setColor("Red")
                .setAirbags(2)
                .setAirConditioning(true)
                .setCarType("Sports")
                .build();

        Car familyCar = new Car.CarBuilder("V6 engine", 4)
                .setColor("Blue")
                .setAirbags(6)
                .setAirConditioning(true)
                .setCarType("Family")
                .build();

        Car electricCar = new Car.CarBuilder("Electric engine", 4)
                .setColor("Green")
                .setAirbags(4)
                .setAirConditioning(true)
                .setCarType("Electric")
                .build();

        System.out.println("Sports car: " + sportsCar);
        System.out.println("Engine: " + sportsCar.getEngine());
        System.out.println("Wheels: " + sportsCar.getWheels());
        System.out.println("Airbags: " + sportsCar.getAirbags());
        System.out.println("Color: " + sportsCar.getColor());
        System.out.println("Air conditioning: " + sportsCar.getAirConditioning());
        System.out.println("Car type: " + sportsCar.getCarType());

        System.out.println();
        System.out.println("Family car: " + familyCar);
        System.out.println("Engine: " + familyCar.getEngine());
        System.out.println("Wheels: " + familyCar.getWheels());
        System.out.println("Airbags: " + familyCar.getAirbags());
        System.out.println("Color: " + familyCar.getColor());
        System.out.println("Air conditioning: " + familyCar.getAirConditioning());
        System.out.println("Car type: " + familyCar.getCarType());

    }
}
