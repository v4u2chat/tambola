# Tambola Claim Validator

## Overview

This is a Java-based implementation of a Tambola (also known as Bingo or Housie) claim validator.

Tambola is a game that is widely played across the world. To participate in a round, players are given tickets (shown below) which have numbers on them. A round has multiple games in it. A round is complete when all games are complete. As numbers are announced by a dealer at random, players match the numbers with those on the ticket and cross them. If they have crossed all numbers needed to win a game, they can claim to be the winner of the game.

### Problem statement: Claim validator

    - Input: Numbers announced so far, a valid ticket and claim for a specific game
    - Output: Accepted | Rejected

### Games

Each round has multiple games. Each game has a winning pattern.

- Top line: The ticket with all the numbers of the top row crossed fastest
- Middle line: The ticket with all the numbers of the middle row crossed fastest
- Bottom line: The ticket with the numbers of the bottom row crossed fastest
- Full house: The ticket with all the 15 numbers crossed first
- Early five: The fastest ticket to have 5 numbers crossed

### Rules

- System only has to return whether a claim is accepted or rejected
- A player's claim to victory is only valid if it is made immediately following the announcement of the number that completes their winning sequence.

---
## Design Patterns in Tambola Claim Validator

### **Strategy**: Flexible validation logic.

- **What**: Defines a family of algorithms (winning conditions) and makes them interchangeable.
- **Where**:
  - `GameRule` interface declares the `validateClaim` method.
  - Concrete classes (`TopLineRule`, `MiddleLineRule`, etc.) implement specific validation logic.
- **How**:
  - `ClaimValidator` uses a `Map` to select the appropriate rule based on claim type.
  - **Benefit**: Easy to add new winning patterns without changing existing code.

### **Simplified Factory**: Centralized rule creation.

- **What**: Centralizes creation of strategy objects in one place.
- **Where**:
  - `ClaimValidator` constructor initializes a `Map` with all game rule instances.
- **How**:
  - Maps claim types (e.g., "Top Row") to their corresponding `GameRule` implementations.
- **Benefit**: Single point of control for available game rules.

### **SRP**: Single Responsibility Principle - Clean separation of concerns.

- **What**: Each class has one reason to change.
- **Where**:
  - `Ticket`: Manages ticket data only.
  - `GameRule` implementations: Handle specific winning conditions.
  - `ClaimValidator`: Orchestrates validation.
- **How**:
  - Responsibilities are split across classes, not mixed.
- **Benefit**: Improves maintainability and testing.

---
## Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or command-line compiler

## Setup

1. Clone or download this repository
2. Open the project in your preferred IDE, or navigate to the project directory in terminal
3. Ensure `ClaimValidatorTest.java` is in your source directory

### Using Command Line

```bash
javac ClaimValidatorTest.java
java ClaimValidatorTest
```

## Project Structure

- `Ticket`: Represents a player's ticket with a 3x9 grid
- `GameRule`: Interface for winning pattern validation
  - Concrete Rule Classes: 
    - `TopLineRule`, `MiddleLineRule`, etc.
- `ClaimValidator`: Main validation logic


## Extending the Game

To add a new winning pattern:

1. Create a new class implementing `GameRule`
2. Add it to the `gameRules` map in `ClaimValidator`

```java
gameRules.put("New Game Type",new NewGameRule());
```


