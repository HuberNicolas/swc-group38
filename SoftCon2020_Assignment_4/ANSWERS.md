# Battleship:
We made our new Battleship game according to these simplified notes: 
![Class Diagram Battleship](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_3/ClassdiagramBattleship.png "Class Diagram Battleship")
The methods, attributes and classes inside the codes are commented. 
Furthermore, we also implemented the following design patterns:

## Singleton
The Singleton is implemented in the class Utils. We used the second method that was presented in the lesson ("uniqueinstance") since the Utils class is garantueed to be used. 
We implemented it like that because we could not find a better place in the game and it is actually not necessary to run the game. So we learned that not every pattern is always useful. You could also argue that any object in an Utils class (like a converter) need to be instantiate exactly once, so it makes the most sense to put the Singleton Pattern in there.

## Observer
The Observer and Subject interfaces have been implemented from scratch. The classess ScoreboardObserver and ScoreboardChecker both inherit one of the interfaces. 
The Checker looks how many Ships are sunk or alive and the observer is always notified. The status of the game could so easily be monitored and be terminated accordingly with the correct game ending message.
By using this, we saw the advantages of using design patterns, as this is an elegant solution to our problem.
With this pattern, it is very easy to update the new state of the game (number of sunken ships).

## Iterator
The Iterator is implemented in the class utils. It is used to iterate over the ships of the defending person when a shot hit a boat. This allows us to find the boat that was hit and therefore needs an update in its current lifepoints. It is implemented as the predefined java.util.Iterator which is similar to the iterator we learned about in class. So there is "iterator", "hasNext" and "Next" to correctly iterate over the objects.
We used it because without it we would have needed for example and additional list or array to store the objects and it would have been more complicated.
So in the end, this iterator is a very helpful tool in this situation.