# Assignment 4:

## Exercise 1:

In the first task, we created a bank management system. Therefore, we created a class Bank, which keeps track of all the actors within the bank (An Arraylist for Technicians was omitted in this case as it serves no purpose, could be added if necessary). 
Those actors all share the three attributes name, surname and ID (considering all have a Person ID, not a subgroup specific ID) which lead to creating an abstract class Person. From there, we started dividing it into different subgroups:
- Customer: The customers have the attributes (IBAN, money) and methods (deposit, withdraw, use creditcard and banktransfer) that are specified in the task. Furthermore, a customer always holds one credit card entity with the specified attributes.
- Technician: A technician has no further attributes than the abstract class Person, but as the bank might want to add other technicians with another area of responsibility, we created another abstract class Technician. The Backend-technician and Web-technician inherit that class and add their specific methods.
- Employee: The third class that inherits from the abstract class Person is the Employee. Every Employee has their corresponding Customer List and some methods. Special employees (as the Mainchief and Sectionchief) have even more possibilities and therefore inherit the employee class. Their corresponding responsibilities and attributes are added to their specific class. 

We also added some default cases, (eg. creating a customer with less than 0 money will lead to an exception and assign the default value savings = 0).

This lead to the following structure of the system: 
![Class Diagram Bank](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_4/UML/Class_Diagram_FINAL.png "Class Diagram Bank mangement System")

## Exercise 2:

To prove the system has no failure or defect, we created test cases. Their specific purpose has been commented inside the code.

To test the system, we created a default case:
- a new bank
- customers, which have different money, age, limits, etc.
- each type of employee (Employee, SectionChief, MainChief)
- both technicians (Web and Backend)

With those created objects, we ran a variety of different test cases and possible errors like: What happens if a person tries to withdraw more money than he has or if a customers pays something by card but the limit is to low to pay.

All tests are commented and in the folder "test" and the file is named "JUnitTests". [JUnitTests](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_4/test/JUnitTests.java)

