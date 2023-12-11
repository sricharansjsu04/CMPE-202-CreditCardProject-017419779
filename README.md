# CMPE-202 Credit Card Project (017419779)

## Overview
This project, part of CMPE 202, focuses on processing credit card records. The primary goal is to read credit card data from various file formats (CSV, JSON, XML), validate the card numbers, and instantiate appropriate subclasses of `CreditCard` for different card types (Visa, MasterCard, American Express, Discover).

### Key Challenges
- **Primary Problem:** 
  - Dynamically handling different credit card types based on card number.
- **Secondary Problems:**
  - Extensibility for adding new credit card types.
  - Validation of card numbers ensuring they adhere to specific formats and do not exceed 19 digits.

### Design Patterns Utilized
- **Factory Method Pattern (Creational Pattern):**
  - Employed for creating objects of `CreditCard` subclasses, allowing dynamic instantiation based on card type.
- **Strategy Pattern (Behavioral Pattern):**
  - Used for defining a family of algorithms for credit card number validation. Each card type has its own validation strategy, making them interchangeable.
- **Abstract Factory Pattern:**
  - In conjunction with the Factory Pattern, different factory types (`CSVOperationFactory`, `JSONOperationFactory`, `XMLOperationFactory`) are defined to handle multiple input and output file formats.
- **Decorator Pattern:**
  - `CreditCardWrapper` acts as an adapter, wrapping the `CreditCard` class to facilitate output object creation in various formats.

### Consequences
- **Factory Method:**
  - Offers flexibility in adding new credit card types without altering existing code.
- **Strategy Pattern:**
  - Decouples validation logic from the card objects, simplifying modifications and additions of new validation rules. However, it might add complexity for simple validation cases.

## Design Extension
The design has been extended to handle multiple input and output file formats.

### Extended Design
- **Abstract Factory Pattern:**
  - Provides an interface for creating families of related objects (`createFileParser` and `createFileWriter`) without specifying their concrete classes.
- **Strategy Pattern:**
  - Different strategies (`CsvFileParser`, `JsonFileParser`, `XMLFileParser`) are implemented to support various file formats. The behavior changes according to the input file format.

### Implementation
- `CreditCardFactory`: Handles instantiation of different `CreditCard` subclasses.
- `CardValidationStrategy`: Encapsulates validation logic for each card type.
- File operation factories: Handle reading and writing of different file formats.

## Design Patterns Diagrams

## Factory Pattern Diagram
![Abstract Factory Pattern](https://github.com/sricharansjsu04/CMPE-202-CreditCardProject-017419779/blob/main/images/Factory.png)

## Strategy Pattern Diagram
![Abstract Factory Pattern](https://github.com/sricharansjsu04/CMPE-202-CreditCardProject-017419779/blob/main/images/strategy.png)

## Abstract Factory Pattern Diagram
![Abstract Factory Pattern](https://github.com/sricharansjsu04/CMPE-202-CreditCardProject-017419779/blob/main/images/abstractFactory.png)

## Adapter Pattern Diagram
![Abstract Factory Pattern](https://github.com/sricharansjsu04/CMPE-202-CreditCardProject-017419779/blob/main/images/Adapter.png)



## Repository Information
- **Author:** Sri Charan Reddy Mallu (017419779)
- **GitHub Repository:** [CMPE-202-CreditCardProject](https://github.com/gopinathsjsu/individual-project-sricharansjsu04)
