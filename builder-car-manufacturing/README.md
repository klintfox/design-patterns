# Car Manufacturing 

## Use Case
We have a car manufacturing company that needs to build cars with different configurations such as:

Sedan
SUV
Truck

For each of these car models, the company needs to set up the specific parts like:

engine type
wheels size
doors configuration
interior material
The Builder Pattern is ideal here because it allows creating different car models step-by-step using distinct builders for each car type.

## Benefits of Using the Builder Pattern
Separation of concerns: The car-building logic is encapsulated in separate builder classes.
Flexibility: Different configurations of cars (e.g., Sedan, SUV, Truck) can be built using the same base Car class.
Readability and maintainability: Code becomes cleaner and easier to read, especially when constructing objects with many parameters.

## Project Structure

```sh
com
└── klinux  
	├── BuilderCarManufacturingApplication.java            # Main Spring Boot application entry point
	├── controller
	│   └── CarController.java               # REST controller for handling requests
	├── model
	│   └── Car.java                         # Car model class representing the product
	├── builder
	│   ├── SedanBuilder.java                # Sedan builder class to assemble a sedan
	│   ├── SUVBuilder.java                  # SUV builder class to assemble an SUV
	│   └── TruckBuilder.java                # Truck builder class to assemble a truck
	├── service
	│   └── CarService.java                  # Service class to handle the business logic
	└── exception
		└── InvalidCarModelException.java
```		

## Request for SUV:

URL: http://localhost:8080/buildCar/suv
Method: GET
Response:

```
{
    "model": "SUV",
    "engine": "3.5L V6",
    "wheels": "18-inch Alloy",
    "doors": "5 Doors",
    "interior": "Premium Leather"
}
```		

## Conclusion
In this example, we used the Builder Pattern to create a flexible, maintainable solution for constructing different types of cars. The builder classes (SedanBuilder, SUVBuilder, TruckBuilder) encapsulate the logic for building each car model, while the CarService class delegates the responsibility of selecting the appropriate builder based on the user's input. This approach ensures that our application is easy to extend and modify, providing a solid foundation for more complex manufacturing systems.