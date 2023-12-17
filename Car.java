public class Car {
    private String color;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private final Engine engine;
    private int mileage;
    public static class Builder {
        private String color;
        private int fuel;
        private int maxFuel;
        private final String model;
        private final int fuelConsumption;
        private int mileage;


        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder maxFuel(int val) {
            maxFuel = val;
            return this;
        }

        public Builder fuel(int val) {
            fuel = val;
            return this;
        }

        public Builder(String model, int fuelConsumption) {
            this.model = model;
            this.fuelConsumption = fuelConsumption;
        }

        public Builder mileage(int val) {
            mileage = val;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
    private Car(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.fuel = builder.fuel;
        this.maxFuel = builder.maxFuel;
        this.engine = new Engine(builder.fuelConsumption);
        this.mileage = builder.mileage;
    }

    public Car(String model, int maxFuel, String color, int mileage, int fuel_consumption){
        this.model = model;
        this.maxFuel = maxFuel;
        this.color = color;
        this.fuel = maxFuel;
        this.mileage = mileage;
        this.engine = new Engine(fuel_consumption);
    }
    private class Engine{
        boolean running;
        int fuel_consumption;
        public Engine(int fc){
            this.fuel_consumption = fc;
            this.running = false;
        }
    }
    public void start(){
        if (fuel >= engine.fuel_consumption){
            engine.running = true;
        }
        else {
            System.out.println("You need refueling!");
        }
    }
    public void stop(){
        engine.running = false;
    }
    public boolean isDriving(){
        return engine.running;
    }

    public void refueling(){
        fuel = maxFuel;
    }
    public void refueling(int a){
        if (fuel + a <= maxFuel){
            fuel += a;
        }
        else{
            fuel = maxFuel;
        }
    }
    public void info(){
        System.out.println();
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Fuel consumption/100 km: " + Integer.toString(engine.fuel_consumption));
        System.out.println("Mileage: " + Integer.toString(mileage));
        System.out.println("Fuel level: " + Integer.toString(fuel));
        if (engine.running == true){
            System.out.println("The car is ranning");
        }
        else{
            System.out.println("The car is standing");
        }
        System.out.println();
    }
    public String getMileage(){
        return Integer.toString(mileage);
    }
    public void driving(){
        if (fuel >= engine.fuel_consumption) {
            fuel -= engine.fuel_consumption;
            mileage += 100;
        } else {
            System.out.println("You need refueling!");
            this.stop();
        }
    }
}

