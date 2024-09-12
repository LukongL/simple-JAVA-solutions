import java.util.InputMismatchException;
import java.util.Scanner;

// Interface representing a general vehicle.
interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

// Interface for Car-specific methods.
interface CarVehicle {
    int getNumberOfDoors();
    String getFuelType();
}

// Interface for Motorcycle-specific methods.
interface MotorVehicle {
    int getNumberOfWheels();
    String getMotorcycleType();
}

// Interface for Truck-specific methods.
interface TruckVehicle {
    double getCargoCapacity();
    String getTransmissionType();
}

// Car class implementing Vehicle and CarVehicle interfaces.
class Car implements Vehicle, CarVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfDoors;
    private String fuelType;

    // Constructor to initialize all fields
    public Car(String make, String model, int year, int numberOfDoors, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return year;
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }
}

// Motorcycle class implementing Vehicle and MotorVehicle interfaces.
class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String motorcycleType;

    // Constructor to initialize all fields
    public Motorcycle(String make, String model, int year, int numberOfWheels, String motorcycleType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfWheels = numberOfWheels;
        this.motorcycleType = motorcycleType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return year;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }
}

// Truck class implementing Vehicle and TruckVehicle interfaces.
class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmissionType;

    // Constructor to initialize all fields
    public Truck(String make, String model, int year, double cargoCapacity, String transmissionType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.cargoCapacity = cargoCapacity;
        this.transmissionType = transmissionType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return year;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }
}

// Main class to demonstrate the Vehicle Information System
public class VehicleInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Vehicle Information System");
            System.out.println("1. Add a Car");
            System.out.println("2. Add a Motorcycle");
            System.out.println("3. Add a Truck");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the scanner buffer
                continue;
            }

            switch (choice) {
                case 1:
                    addNewCar(scanner);
                    break;
                case 2:
                    addNewMotorcycle(scanner);
                    break;
                case 3:
                    addNewTruck(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    // Method to add a new Car
    private static void addNewCar(Scanner scanner) {
        try {
            System.out.print("Enter car make: ");
            String make = scanner.nextLine();
            System.out.print("Enter car model: ");
            String model = scanner.nextLine();
            System.out.print("Enter car year of manufacture: ");
            int year = scanner.nextInt();
            System.out.print("Enter number of doors: ");
            int doors = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter fuel type (petrol, diesel, electric): ");
            String fuelType = scanner.nextLine();

            // Creating and initializing the Car object with all attributes at once
            Car car = new Car(make, model, year, doors, fuelType);

            displayVehicleDetails(car);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            scanner.nextLine(); // clear the scanner buffer
        }
    }

    // Method to add a new Motorcycle
    private static void addNewMotorcycle(Scanner scanner) {
        try {
            System.out.print("Enter motorcycle make: ");
            String make = scanner.nextLine();
            System.out.print("Enter motorcycle model: ");
            String model = scanner.nextLine();
            System.out.print("Enter motorcycle year of manufacture: ");
            int year = scanner.nextInt();
            System.out.print("Enter number of wheels: ");
            int wheels = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter motorcycle type (sport, cruiser, off-road): ");
            String type = scanner.nextLine();

            // Creating and initializing the Motorcycle object with all attributes at once
            Motorcycle motorcycle = new Motorcycle(make, model, year, wheels, type);

            displayVehicleDetails(motorcycle);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            scanner.nextLine(); // clear the scanner buffer
        }
    }

    // Method to add a new Truck
    private static void addNewTruck(Scanner scanner) {
        try {
            System.out.print("Enter truck make: ");
            String make = scanner.nextLine();
            System.out.print("Enter truck model: ");
            String model = scanner.nextLine();
            System.out.print("Enter truck year of manufacture: ");
            int year = scanner.nextInt();
            System.out.print("Enter cargo capacity (in tons): ");
            double capacity = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Enter transmission type (manual, automatic): ");
            String transmissionType = scanner.nextLine();

            // Creating and initializing the Truck object with all attributes at once
            Truck truck = new Truck(make, model, year, capacity, transmissionType);

            displayVehicleDetails(truck);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            scanner.nextLine(); // clear the scanner buffer
        }
    }

    // Method to display vehicle details
    private static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year of Manufacture: " + vehicle.getYearOfManufacture());

        if (vehicle instanceof CarVehicle) {
            CarVehicle car = (CarVehicle) vehicle;
            System.out.println("Number of Doors: " + car.getNumberOfDoors());
            System.out.println("Fuel Type: " + car.getFuelType());
        } else if (vehicle instanceof MotorVehicle) {
            MotorVehicle motorcycle = (MotorVehicle) vehicle;
            System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
            System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
        } else if (vehicle instanceof TruckVehicle) {
            TruckVehicle truck = (TruckVehicle) vehicle;
            System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
            System.out.println("Transmission Type: " + truck.getTransmissionType());
        }
    }
}
