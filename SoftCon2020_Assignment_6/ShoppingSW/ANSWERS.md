# Assignment 6:
## Description:


Regarding the Responsibility Driven Design pattern, we would implement the ShoppingSW online shopping platform as follows:

## Workflow

First, we extracted the *key points* from the assignment:
![alt text](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_6/ShoppingSW/ClassSelection.PNG)

Secondly, we used the techniques we've learnt in class regarding RD-Design:
![alt text](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_6/ShoppingSW/RDDesign.png)

After creating CRC-Cards, we could finally create a Class Diagram.


## Class Diagram
![alt text](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_6/ShoppingSW/ClassDiagram.png)

As in the class diagram described, we model the following main classes:
  * Shopping Platform
  * User
  * Product
  * Cart
  * Search bar

All of them can be interpreted as real physical item with a clear hierarchy, except the search bar. However, it makes sense to create a conceptual model of the search bar, because bundles several functions. We will take a look at each of the classes:

## Main Classes

### Shopping Platform
This entity models the platform where all the transactions are made. It has no subclasses. We would implement this with this Singleton design pattern, since there can only exist one shopping platform. The following methods could be useful:
    Attribute
  - ArrayList<Users> userList = new ArrayList<User>()
  - SearchBar s = new SearchBar

    Methods
  - createUser(String name, String type)
  - listAllUsers()
  - deleteUser(String name)

### User
The main user class has 3 subclasses: Normal customer, gold customer and platinum customer. These subclasses define, how many items a user can sell at the same time (1, 5 or 10), however, these attributes are specified in each subclass. The main user class implements the following methods, which every user is able to perform, regardless of his/her level:
 - setPrice(Product p, int Price)
 - logIn()
 - sell(Product p)
 - buy(Product p)
 - checkCart()
 - removeFromCart(Product p)
 - buyFromAnotherUser(User u, Product p, int Price)
 - checkout(String paymentMethod)
 - search(Product p)
 - setFilterCategory(Product p)
 - setFilterTypeOfClothes(Clothes c)

### Product
The main product class has 2 subclasses: Clothes and Boots. Each product has the following attributes:
  - String name
  - String color
  - int size
  - int prize

### Cart
The cart class has no subclasses. It models a cart, that contains items. The following attributes and methods would be implemented:
    Attribute
  - ArrayList<Product> cartList = new ArrayList<Product>()

    Methods
  - checkCart()
  - addProduct(Product p)
  - removeProduct(Product p)

### Search bar
Also the search bar has no subclasses. Using this class, the user is able to search and filter the online shopping platform:
    Attribute
  - ArrayList<Product> globalListOfAllItems = new ArrayList<Product>()

    Methods
  - setFilterCategory(Product p)
  - setFilterTypeOfClothes(Clothes c)

## Subclasses

### normal customer, gold customer and platinum customer
Each customer class has a different defined attribute numberOfMaxProductSelling, namely:
  - normal Customer : 1
  - golden Customer : 5
  - platinum Customer : 10

### dress, trousers, shirt
Each of these subclasses can generate entities. Having said that, can create a dress object, a trousers object and a shirt object, all of them will inherit the attributes of the main class clothes.

### boots, sneakers
Each of these subclasses can generate entities. Having said that, can create a boots object and a sneakers object, both of them will inherit the attributes of the main class shoes.


## Final UML Diagram
This lead to the final uml class diagram:
![alt text](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_6/ShoppingSW/UML_Diagram.PNG)