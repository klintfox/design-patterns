# Payment Processing System - Factory Method Pattern Example

This project demonstrates the **Factory Method Pattern** in a payment processing system built with **Spring Boot** and **Java 17**. The Factory Method pattern is used to instantiate different payment processors (such as **CreditCard**, **PayPal**, and **Stripe**) based on the user's selection or configuration.

## Key Concepts

- **Factory Method Pattern**: This design pattern defines an interface for creating objects but allows subclasses or the factory to decide which class to instantiate. In this case, the **PaymentProcessorFactory** decides which **PaymentProcessor** (like **CreditCardProcessor**, **PayPalProcessor**, or **StripeProcessor**) to instantiate.
  
- **PaymentProcessor Interface**: The common interface that all payment processors implement. It defines the `processPayment(double amount)` method.
  
- **Concrete Payment Processors**: Each payment processor (`CreditCardProcessor`, `PayPalProcessor`, `StripeProcessor`) implements the `PaymentProcessor` interface, providing specific implementations for processing payments.

## Project Structure

The project is organized as follows:

### 1. **PaymentProcessor Interface**

This interface defines the method that all payment processors must implement.

```
public interface PaymentProcessor {
    void processPayment(double amount);
}
```
### 2. Concrete Payment Processors
Each payment processor (CreditCard, PayPal, Stripe) implements the PaymentProcessor interface, providing its own processPayment method.

CreditCardProcessor.java
```
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of $" + amount);
    }
}

PayPalProcessor.java

public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal Payment of $" + amount);
    }
}
StripeProcessor.java

public class StripeProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe Payment of $" + amount);
    }
}
```
### 3. PaymentProcessorFactory (Factory Method)
The factory class is responsible for instantiating the correct payment processor based on the payment method passed in.
```
public class PaymentProcessorFactory {
    @Autowired
    private CreditCardProcessor creditCardProcessor;
    @Autowired
    private PayPalProcessor payPalProcessor;
    @Autowired
    private StripeProcessor stripeProcessor;

    public PaymentProcessor getPaymentProcessor(String paymentMethod) {
        switch (paymentMethod.toLowerCase()) {
            case "creditcard":
                return creditCardProcessor;
            case "paypal":
                return payPalProcessor;
            case "stripe":
                return stripeProcessor;
            default:
                throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
    }
}
```
## 4. PaymentService
This service class uses the PaymentProcessorFactory to fetch the correct processor and handle the payment.
```
public class PaymentService {
    @Autowired
    private PaymentProcessorFactory paymentProcessorFactory;

    public void processPayment(String paymentMethod, double amount) {
        PaymentProcessor processor = paymentProcessorFactory.getPaymentProcessor(paymentMethod);
        processor.processPayment(amount);
    }
}
```
### 5. PaymentController (REST Controller)
The controller exposes an API endpoint to process payments by calling the PaymentService.
```
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/processPayment")
    public String processPayment(@RequestParam String paymentMethod, @RequestParam double amount) {
        paymentService.processPayment(paymentMethod, amount);
        return "Payment processed via " + paymentMethod;
    }
}
```
### 6. Unit Test for PaymentService
Unit tests ensure the correct behavior of the PaymentService. The factory method is mocked to isolate the tests from the actual implementation of payment processors.
```
@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
    @Mock
    private PaymentProcessorFactory paymentProcessorFactory;

    @Mock
    private PaymentProcessor mockPaymentProcessor;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testProcessPayment_creditCard() {
        when(paymentProcessorFactory.getPaymentProcessor("creditcard")).thenReturn(mockPaymentProcessor);

        paymentService.processPayment("creditcard", 100.0);
        verify(mockPaymentProcessor).processPayment(100.0);
    }
}
```
### 7. Running the Application
Start the application by running the PaymentApplication.java class with @SpringBootApplication.
Access the payment processing endpoint using a browser or Postman:

```bash
GET http://localhost:8080/processPayment?paymentMethod=creditcard&amount=100.0
```
**paypal**
![Get Payment](https://github.com/klintfox/design-patterns/blob/main/api-factory-method-payment/src/main/resources/captures/1.PNG)

**credit card**
![Get Payment](https://github.com/klintfox/design-patterns/blob/main/api-factory-method-payment/src/main/resources/captures/2.PNG)


### Main Points of the Design
- Factory Method: The PaymentProcessorFactory decides which concrete payment processor to instantiate based on the input payment method (credit card, PayPal, or Stripe).
- Spring Boot Integration: The factory and processors are managed as Spring beans using @Component and @Autowired.
- Separation of Concerns: The payment processing logic is encapsulated within each concrete payment processor, making the system easy to extend with new processors in the future.
- Unit Testing: The design supports unit testing by mocking the PaymentProcessorFactory to isolate tests and validate that the correct payment processor is used.

### Conclusion
This project demonstrates how the Factory Method Pattern can be applied to a real-world scenario like payment processing systems. Using this pattern, you can easily extend the system to support new payment methods without modifying the existing code, making it scalable and maintainable.