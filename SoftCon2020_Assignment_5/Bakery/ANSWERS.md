# Assignment 5:

## Part 1:

For the central office we used the design pattern **Singleton**, since the description implies, that there could only be exactly one central office.

Considering **inheritance and encapsulation**, we made an abstract class SuperBakery for the different bakeries because every bakery needs certain attributes like a name.
For the foods we made two abstract classes: FoodDecorator and FoodItem. They define certain attributes, and it is also possible to add new food for example coffee.
To decorate the food we used the concept of decoration. By using this food-structure, it is very easy to implement new products (fooditems) and to implement new decorators.
You can also "stock" each bakery individually: One bakery can sell sandwiches and cake and another maybe just sandwiches and new introduced "coffee".
Additionally, it is also possible that one bakery has different decorators for their product:
So could make a vegan bakery which does not sell ham, cheese and tuna in their sandwiches.

Implementing of the Composite Pattern:
The **composite patter** we did encounter allows us to compose objects into tree structures to represent a part-whole hierarchies. Regarding the actual task, we model the hierarchy of the different bakeries types with compsite pattern. 

Implementing of the Decorator Pattern:
The structure is similar to the coffee example from the lecture. Both of the classes Sandwich and Cake have several options to add condiments. The new behavior is not acquired by inheritance but by composing objects together. Using the **decorator pattern**, we can mix and match decorators (for instance 
"chocolate" for a Cake object or "tuna" for a sandwich object) for in any way. In other words, we can attach additional responsibilities to an object dynamically, thus extending the functionality of an object of the classes Cake or Sandwich.