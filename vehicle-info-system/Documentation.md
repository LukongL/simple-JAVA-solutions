Vehicle Information System Documentation

Project Overview
The Vehicle Information System is developed to efficiently manage various types of vehicles, including cars, motorcycles, and trucks. It provides functionalities for retrieving, setting, and displaying vehicle details, ensuring consistency and ease of use. Object-oriented design principles are employed to enhance modularity and maintainability, offering developers a structured approach to handle vehicle data effectively.

Key Features
•	Encapsulation: Utilization of private fields and public methods to encapsulate and manage the internal state of vehicle objects securely.
•	Modularity: Division of functionalities into separate classes for better organization, reusability, and scalability.
•	Interfaces: Implementation of interfaces to enforce common behavior across different vehicle types, promoting consistency in data retrieval and manipulation.
•	Interactive Command-Line Interface: Intuitive command-line interface facilitating user interaction for seamless access to vehicle information.



Class Descriptions

Vehicle Interface
•	Methods:
•	getMake(): Retrieves the make of the vehicle.
•	getModel(): Retrieves the model of the vehicle.
•	getYearOfManufacture(): Retrieves the year of manufacture of the vehicle.

CarVehicle Interface
•	Methods:
•	getNumberOfDoors(): Retrieves the number of doors of the car.
•	getFuelType(): Retrieves the fuel type of the car.

MotorVehicle Interface
•	Methods:
•	getNumberOfWheels(): Retrieves the number of wheels of the motorcycle.
•	getMotorcycleType(): Retrieves the type of motorcycle.

TruckVehicle Interface
•	Methods:
•	getCargoCapacity(): Retrieves the cargo capacity of the truck.
•	getTransmissionType(): Retrieves the transmission type of the truck.

Car Class
•	Implements: Vehicle, CarVehicle Interfaces
•	Methods:
•	getMake(): Retrieves the make of the car.
•	getModel(): Retrieves the model of the car.
•	getYearOfManufacture(): Retrieves the year of manufacture of the car.
•	getNumberOfDoors(): Retrieves the number of doors of the car.
•	getFuelType(): Retrieves the fuel type of the car.

Motorcycle Class
•	Implements: Vehicle, MotorVehicle Interfaces
•	Methods:
•	getMake(): Retrieves the make of the motorcycle.
•	getModel(): Retrieves the model of the motorcycle.
•	getYearOfManufacture(): Retrieves the year of manufacture of the motorcycle.
•	getNumberOfWheels(): Retrieves the number of wheels of the motorcycle.
•	getMotorcycleType(): Retrieves the type of motorcycle.	
Truck Class
•	Implements: Vehicle, TruckVehicle Interfaces
•	Methods:
•	getMake(): Retrieves the make of the truck.
•	getModel(): Retrieves the model of the truck.
•	getYearOfManufacture(): Retrieves the year of manufacture of the truck.
•	getCargoCapacity(): Retrieves the cargo capacity of the truck.
•	getTransmissionType(): Retrieves the transmission type of the truck.

VehicleInformationSystem Class
•	Methods:
•	main(String[] args): Entry point of the program, facilitating user interaction and operation execution.
•	addNewCar(Scanner scanner): Adds a new car by taking user input.
•	addNewMotorcycle(Scanner scanner): Adds a new motorcycle by taking user input.
•	addNewTruck(Scanner scanner): Adds a new truck by taking user input.
•	displayVehicleDetails(Vehicle vehicle): Displays the details of the given vehicle.


Utilization of Interfaces
•	Vehicle Interface: Defines common methods for retrieving vehicle details, ensuring a consistent structure for different vehicle types.
•	Implementation in Concrete Classes: Concrete classes like Car, Motorcycle, and Truck implement the Vehicle interface, providing specific implementations for vehicle attributes.

Running the Program
1.	Compile the program using a Java compiler:
javac VehicleInformationSystem.java 
2.	Run the compiled program:
java VehicleInformationSystem 
3.	Follow the on-screen instructions to interact with the system. Create objects of different vehicle types, provide relevant information, and display vehicle details as required.

Example Usage
Vehicle Information System
1. Add a Car
2. Add a Motorcycle
3. Add a Truck
4. Exit

Enter your choice: 1
Enter car make: Toyota
Enter car model: Camry
Enter car year of manufacture: 2020
Enter number of doors: 4
Enter fuel type (petrol, diesel, electric): petrol

Vehicle Details:
Make: Toyota
Model: Camry
Year of Manufacture: 2020
Number of Doors: 4
Fuel Type: petrol

==========================================

Vehicle Information System
1. Add a Car
2. Add a Motorcycle
3. Add a Truck
4. Exit

Enter your choice: 2
Enter motorcycle make: Harley-Davidson
Enter motorcycle model: Street 750
Enter motorcycle year of manufacture: 2019
Enter number of wheels: 2
Enter motorcycle type (sport, cruiser, off-road): cruiser

Vehicle Details:
Make: Harley-Davidson
Model: Street 750
Year of Manufacture: 2019
Number of Wheels: 2
Motorcycle Type: cruiser
