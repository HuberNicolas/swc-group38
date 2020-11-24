# Assignment 5:

## Part 1:

For the central office we used the design pattern Singleton.
For the different bakeries we made an abstract class SuperBakery because every bakery needs certain attributes like a name.

For the foods we made two abstract classes: FoodDecorator and FoodItem. They define certain attributes, and it is also possible to add new food for example coffee.
To decorate the food we used the concept of decoration. By using this food-structure, it is very easy to implement new products (fooditems) and to implement new decorators.
You can also "stock" each bakery individually: One bakery can sell sandwiches and cake and another maybe just sandwiches and new introduced "coffee".
Additionally, it is also possible that one bakery has different decorators for their product:
So could make a vegan bakery which does not sell ham, cheese and tuna in theri sandwiches. 