import java.util.Scanner;

// Base Vehicle class
class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}

// Car subclass inheriting from Vehicle
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String make, String model, int year, int numberOfDoors) {
        super(make, model, year); // Call to superclass (Vehicle) constructor
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() { return numberOfDoors; }

    @Override
    public String toString() {
        return super.toString() + ", Doors: " + numberOfDoors;
    }
}

// Customer class to represent customers
class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

// Main class to run the application
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Cars (which are Vehicles)
        System.out.print("Enter the number of cars: ");
        int carCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Vehicle[] vehicles = new Vehicle[carCount];

        for (int i = 0; i < carCount; i++) {
            System.out.println("Enter details for Car " + (i + 1) + ":");
            System.out.print("Make: ");
            String make = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = scanner.nextInt();
            System.out.print("Number of Seats: ");
            int numberOfDoors = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            vehicles[i] = new Car(make, model, year, numberOfDoors); // Polymorphism: Car treated as Vehicle
        }

        // Input for Customers
        System.out.print("Enter the number of customers: ");
        int customerCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Customer[] customers = new Customer[customerCount];

        for (int i = 0; i < customerCount; i++) {
            System.out.println("Enter details for Customer " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            customers[i] = new Customer(name, email);
        }

        // Display Cars
        System.out.println("\nAvailable Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle); // Calls Car's overridden toString method
        }

        // Display Customers
        System.out.println("\nRegistered Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        scanner.close();
    }
}
