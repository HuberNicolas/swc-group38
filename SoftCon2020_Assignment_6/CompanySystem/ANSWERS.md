# Assignment 6:
## Description:



To create this specific Company System, we used the MVC-Design Pattern. In example, MVCPatternDemo is like the Main Class, the Employee serves as the Model, the View and Controller are named after their specific funtion.

## Design Choices
In this task we had to use the MVC-Design pattern and we implemented it the following way: The MVCPAtternDemo class funcitons as the main class and shows the example outputs.For this, it uses Employee retrieveEmployeFromDatabase().

The Employee class is our model. It defines the specific attributes of an employee like name or id. This class also caontains the setter and getter.

The Utils class has the purpose to provide the funcion generateID(). This function uses the ArrayList<Integer> IDList to make unique ID's for the employees.

The class View can print out the details of a created employee. It can either print specific data like printName or the whole details with printEmpolyeeDetails(Employee e).

The Controllerclass gets initialized. It has the ability to set the specific details for the employee like setEmployeeSurname. It can also directly print out the updated data by using updateView() which uses printEmpolyeeDetails from the View class.

## UML
This is the UML.
![Class Diagram Company](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_6/CompanySystem/UML/UML_2.png "Class Diagram Company System")
