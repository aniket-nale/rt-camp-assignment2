# rt-camp-assignment2

# Playwright TestNG Framework for [sauce demo](https://www.saucedemo.com/)

This project demonstrates the automation of a sauce demo website using **Playwright** and **TestNG** in Java. It
includes features like sorting products, adding products to the cart, and completing the checkout process.

## Setup

Before test execution, `@BeforeMthod` is responsible for initializing the browser, navigating to the homepage, and logging into the application before each test case.

## Features

1. **Launch Browser and Login**
    - Launch a browser instance.
    - Navigates to the homepage and login with credentials.

2. **Sorting Functionality**
    - Sort products in descending order (Z to A).
    - Sort products by price (High to Low).

3. **Cart and Checkout**
    - Adds multiple products to the cart.
    - Validates the checkout process.

## Project Structure

### Packages

- **`com.qa.testrunner`**  
  Contains the test runner class, `TestNG`.

- **`com.qa.assignment.pages`**  
  Page Object Model (POM) classes:
    - `HomePage`: Launch the homepage.
    - `LoginPage`: Handles user login.
    - `ProductPage`: Manages actions like sorting and adding items to the cart.
    - `CheckoutPage`: Automating checkout process.

- **`com.qa.constants`**  
  Contains constants for credentials, locators, URLs, and user information.

### Test Cases

- **Sort order - Z to A**  
  Tests sorting functionality in descending alphabetical order.  
  **Priority:** 1

- **Sort order - High to Low**  
  Tests sorting functionality based on price from high to low.  
  **Priority:** 2

- **Adding products to the cart and validating checkout process**
    - Adds multiple products to the cart.
    - Proceed to checkout.
    - Fills in user information and completes the process.  
      **Priority:** 3

## Setup and Execution

### Prerequisites

- Java 8 or higher
- Maven
- Playwright Java Library
- TestNG Framework
- A compatible browser (e.g., Chrome, Chromium)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/aniket-nale/rt-camp-assignment2.git
   ```
2. Navigate to the project directory:
   ```bash
   cd rt-camp-assignment2
   ```
3. Install dependencies:
   ```bash
   mvn install
   ```

### Execution

1. Run the test suite using Maven:
   ```bash
   mvn test
   ```
2. Results will be displayed in the console.
3. Browser sessions are recorded and saved in the `Test_video/` directory for debugging purposes. Ensure the directory
   exists in the project root.

## Cleanup

After test execution, the browser and Playwright instances are closed in the `@AfterMethod` hook to ensure proper
resource cleanup.

## Author
**Aniket Nale**
