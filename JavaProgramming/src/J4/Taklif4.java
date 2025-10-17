package J4;
class Car {
    // Maximum allowed speed
    private static final int MAX_SPEED = 120;

    // Properties
    private String name;
    private String model;
    private int year;
    private String color;
    private String type;
    private int speed;
    private boolean isRunning;
    private boolean lightsOn;
    private String direction;

    // Constructor
    public Car(String name, String model, int year, String color, String type) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.color = color;
        this.type = type;
        this.speed = 0;
        this.isRunning = false;
        this.lightsOn = false;
        this.direction = "Straight";
    }

    // Start the car
    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println( name + " started!");
        } else {
            System.out.println(name + " is already running!");
        }
    }

    // Stop the car
    public void stop() {
        if (isRunning) {
            speed = 0;
            isRunning = false;
            System.out.println( name + " stopped!");
        } else {
            System.out.println(  name + " is already stopped!");
        }
    }

    // Increase speed
    public void accelerate(int amount) {
        if (!isRunning) {
            System.out.println("Start " + name + " first!");
            return;
        }

        int newSpeed = speed + amount;
        if (newSpeed > MAX_SPEED) {
            speed = MAX_SPEED;
            System.out.println("Maximum speed reached (" + MAX_SPEED + " km/h)!");
        } else {
            speed = newSpeed;
            System.out.println( name + " speed increased to " + speed + " km/h");
        }
    }

    // Overloaded method with default amount
    public void accelerate() {
        accelerate(10);
    }

    // Decrease speed
    public void decreaseSpeed(int amount) {
        if (!isRunning) {
            System.out.println( name + " is not running!");
            return;
        }

        int newSpeed = speed - amount;
        if (newSpeed < 0) {
            speed = 0;
            System.out.println( name + " stopped (speed: 0)");
        } else {
            speed = newSpeed;
            System.out.println( name + " speed decreased to " + speed + " km/h");
        }
    }

    // Overloaded method with default amount
    public void decreaseSpeed() {
        decreaseSpeed(10);
    }

    // Honk
    public void honk() {
        if (isRunning) {
            System.out.println("Beep beep! (" + name + ")");
        } else {
            System.out.println(name + " is not running!");
        }
    }

    // Turn lights on
    public void lightOn() {
        if (!lightsOn) {
            lightsOn = true;
            System.out.println( name + " lights turned on");
        } else {
            System.out.println("Lights are already on!");
        }
    }

    // Turn lights off
    public void lightOff() {
        if (lightsOn) {
            lightsOn = false;
            System.out.println( name + " lights turned off");
        } else {
            System.out.println("Lights are already off!");
        }
    }

    // Turn left
    public void turnLeft() {
        if (!isRunning) {
            System.out.println(" Start " + name + " first!");
            return;
        }
        direction = "Left";
        System.out.println( name + " turned left");
    }

    // Turn right
    public void turnRight() {
        if (!isRunning) {
            System.out.println("Start " + name + " first!");
            return;
        }
        direction = "Right";
        System.out.println(name + " turned right");
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public String getDirection() {
        return direction;
    }

    // Display car info
    public void displayInfo() {
        System.out.println("\n========== Car Info ==========");
        System.out.println("Name: " + name);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Type: " + type);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Running: " + (isRunning ? "Yes" : "No"));
        System.out.println("Lights: " + (lightsOn ? "On" : "Off"));
        System.out.println("Direction: " + direction);
        System.out.println("==============================\n");
    }
}

// Main class to test the Car class
public class Taklif4 {
    public static void main(String[] args) {
        // Create multiple cars
        Car car1 = new Car("BMW X5", "X5 M50i", 2024, "Black", "SUV");
        Car car2 = new Car("Tesla Model 3", "Model 3 Performance", 2023, "White", "Sedan");
        Car car3 = new Car("Porsche 911", "911 Turbo S", 2024, "Red", "Sports");

        System.out.println("========== Testing Car 1: BMW X5 ==========\n");
        car1.displayInfo();
        car1.start();
        car1.lightOn();
        car1.accelerate(30);
        car1.accelerate(40);
        car1.accelerate(50);
        car1.accelerate(30); // This will hit max speed
        car1.honk();
        car1.turnLeft();
        car1.decreaseSpeed(20);
        car1.displayInfo();
        car1.stop();
        car1.lightOff();

        System.out.println("\n========== Testing Car 2: Tesla Model 3 ==========\n");
        car2.displayInfo();
        car2.start();
        car2.accelerate(50);
        car2.accelerate(60);
        car2.turnRight();
        car2.honk();
        car2.displayInfo();

        System.out.println("\n========== Testing Car 3: Porsche 911 ==========\n");
        car3.displayInfo();
        car3.start();
        car3.lightOn();
        car3.accelerate(40);
        car3.accelerate(40);
        car3.accelerate(40);
        car3.accelerate(); // Using default amount (10)
        car3.turnLeft();
        car3.decreaseSpeed(30);
        car3.displayInfo();
        car3.stop();
    }
}