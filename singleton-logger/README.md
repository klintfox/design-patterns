# Logging System - Singleton Pattern

## Explanation of Code

### LogManager Class:

- **Singleton Pattern:**
  - The `LogManager` class follows the **Singleton pattern** where it has a private static instance (`instance`), and a private constructor to prevent external instantiation.
  - The `getInstance()` method returns the single instance of the class. If the instance is `null`, it creates a new one (lazy initialization).
  
- **Logging to File:**
  - The `log()` method is responsible for writing log messages. These messages are printed to both the **console** and written to the `application.log` file.
  
### Spring Boot Application (`ApiSingletonLoggerApplication`):

- **CommandLineRunner Interface:**
  - The `ApiSingletonLoggerApplication` implements the `CommandLineRunner` interface, which allows us to run code when the Spring Boot application starts.
  - The `run()` method gets the Singleton instance of `LogManager` and calls the `log()` method to log messages such as `"Application Started"`, `"Performing some operation..."`, and `"Application Finished"`.

## Step 5: Verify Output

1. **Check the Console Output:**
   - When you run the application, you should see log messages printed to the console, such as:
     ```bash
     Application Started
     Performing some operation...
     Application Finished
     ```

2. **Check the `application.log` file:**
   - You will also see the same log messages appended to the `application.log` file located in your project directory (`logs/application.log`).
   - The format will be similar to:
     ```plaintext
     2025-02-25 09:15:00 - Application Started
     2025-02-25 09:15:01 - Performing some operation...
     2025-02-25 09:15:02 - Application Finished
     ```

## Key Points about Singleton Pattern in this Example:

- **Single Instance:** Only one instance of `LogManager` is created throughout the application, ensuring efficient resource usage.
- **Global Access:** The `LogManager` instance can be accessed globally throughout the application via the `getInstance()` method.
- **Lazy Initialization:** The `LogManager` instance is only created when it is first needed (i.e., the `getInstance()` method is called).

## Conclusion

This is a basic implementation of the **Singleton pattern** in a Spring Boot application using Java 17 and Maven. The example demonstrates how to apply the Singleton pattern while logging messages both to the console and a log file (`application.log`).

You can enhance this implementation further by utilizing Spring Boot's built-in Singleton scope, but this example focuses on the classic Singleton pattern approach.

