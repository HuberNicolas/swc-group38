# Assignment 4:

## Exercise 1:

In the first task, we created a bank management system. Therefore, we created a class Bank, which keeps track of all the actors within the bank. 
Those actors all share the three attributes name, surname and ID (considering all have a Person ID, not a subgroup specific ID) which lead to creating an abstract class Person. From there, we started dividing it into different subgroups:
- Customer: The customers have the attributes (IBAN, money) and methods (deposit, withdraw, use creditcard and banktransfer) that are specified in the task. Furthermore, a customer always holds one credit card entity with the specified attributes.
- Technician: A technician has no further attributes than the abstract class Person, but as the bank might want to add other technicians with another area of responsibility, we created another abstract class Technician. The Backend-technician and Web-technician inherit that class and add their specific methods.
- Employee: The third class that inherits from the abstract class Person is the Employee. Every Employee has their corresponding Customer List and some methods. Special employees (as the Mainchief and Sectionchief) have even more possibilities and therefore inherit the employee class. Their corresponding responsibilities and attributes are added to their specific class. 

This lead to the following structure of the system: 
![Class Diagram Bank](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_4/UML/Class_Diagram.png "Class Diagram Battleship")

## Exercise 2:

To prove the system has no failure or defect, we created test cases. Their specific purpose has been commented inside the code.