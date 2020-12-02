# Assignment 5:
## Description:



To create this specific airport shuttle service, the system needs to handle two actors: the customer and the vehicle. 
The customer is pretty simple: it takes the date and the car it wants do drive. Depending on what car he chose, the drive method prints the corresponding attributes.
As all the cars have the same variables that need to be declared, an abstract class Vehicle was created. It has the following "simple" attributes:
- name: the name of the car
- cost: the price
and the following "behavior" attributes that where implemented with a "strategy" pattern as learned in class:
- costB: the cost behavior (can be implemented as: flat-rate, CHF/h, ...)
- bagB: the bag behavior (how many of which bags can be transported)
- speedB: the speed of the car (can be implemented as: slow, middle, fast, ...)
- fuelB: what fuel does it need (can be implemented as: gasoline, diesel, electric, ...)
This makes it easy to change/add/delete specific vehicles and their corresponding behaviors.

Each subclass of the Vehicle (Micro car, family car, supercar, bus, ...) sets their specific behavior at the construction(e.g. sets speedBehavior to normalSpeed that inherits from the SpeedBehavior-interface).
They also all inherit the printRide() method that prints their values that have been set (which is called when the customer wants to "ride"). 

Regarding the **strategy** design pattern, the implementation of the airport shuttle service guarantees, that the system can be extended easily:
- Extending the abstract class Vehicle allows creating new classes for vehicle entities for instance a new class named MegaCar.
- Taking use of the strategy design pattern, the behaviour of a specific entity can set dynamically. Adding more interfaces for new behaviours e.g. comfortLevelBehaviour is possible at any time.
  Implementing these new interfaces allows setting new behaviours for instance a cosyComfortLevel implements comfortLevelBehaviour.



