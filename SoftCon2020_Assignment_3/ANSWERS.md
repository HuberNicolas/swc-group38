# Battleship:
We made our new Battleship game according to this diagram: 
![Class Diagram Battleship](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_3/ClassdiagramBattleship.png "Class Diagram Battleship")
We've commented our code, so we want explain every line. We also implemented the following desing patterns which we will describe know how and why they got implemented.

## Singleton
Singleton is implemented in the class Utils excactly like we learned it in the lesson. So we used "uniqueinstance". We implemented it like that because we could not find a better place in the game and it is actually not necessary to run the game. So we learned that not every pattern is allways useful.

##Observer
Observer is implemented in  the classes ScoreboardObserver and ScoreboardChecker. 
The Checker looks how many Ship Objects are sunk or alive and the Observer is getting this information. 
This pattern is very imporatant as we had to use it to easily check if the player or the computer won after a turn. By using this, we saw the advantages of using design patterns, as this is an elegant solution to our problem.
With this pattern, it is very easy to update the new state of the game (number of sunken ships).

##Iterator
Iterator is implemented in the class utils. Is it used to iterate over the ships of the defending person when a shot hit a about. It is implemented very similar like we learned it in the class. So ther is "iterator" and "hasNext" and "Next" to correctly iteratore over the objects.
We used it because it is very handy in this situation because without it we would have needed for example and addtional list or array to store the objects and it would have been more complicated.
So in the end, this iterator is a very helpful tool in this situation.