# E-commerceCart
Develop a system where users can view available products stored in an ArrayList, manage their personal shopping cart using a LinkedList, and proceed through a simulated checkout process.

## Objective
The goal of this project is to develop a simplified e-commerce cart system. This system will allow users to browse available products, add items to their cart, remove or reorder items, and proceed through a simulated checkout process.

## 1. Introduction
As e-commerce has grown rapidly, shopping carts are now a fundamental component of online shopping. Building a cart system provides practical experience in data management, user interaction, and system operations within an e-commerce context.

## 2. Project Features and Tasks

### a. Product Management
- **Product Storage**: Use an `ArrayList` to store all available products. Each product will include:
  - ID
  - Name
  - Description
  - Price
  - Stock count
- **Product Operations**:
  - Add, delete, and update product details.
  - Display a list of all products with relevant information.

### b. User Cart Management
- **Cart Representation**: Use a `LinkedList` to simulate a user’s cart, which will support flexible item management.
- **Cart Operations**:
  - Allow users to add products to their cart by specifying the product ID.
  - Provide the option to remove items from the cart.
  - Enable users to reorder items in the cart.
  - Display the current items in the cart, along with the total cost.

### c. Checkout System
- **Checkout Process**:
  - Allow users to confirm items in their cart to proceed to checkout.
  - Simulate the purchase by updating the stock count of each purchased item.
  - Provide an invoice summary showing the purchased items, their details, and the total cost.

### d. User Interface
- **Text-Based Console Interface**:
  - Implement a simple, text-based interface where users can perform the above tasks.
  - Include input validation to ensure smooth navigation and prevent system errors, helping guide users through each process. 

This project will reinforce skills in Java programming, especially in managing data collections like `ArrayList` and `LinkedList`, and will introduce essential concepts in e-commerce operations.
