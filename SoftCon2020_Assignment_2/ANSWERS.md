# PART 1: Battleship:
First, we made a diagram, to illustrate the overall structure of our program. 
![Class Diagram Battleship](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_2/ClassdiagramBattleship.png "Class Diagram Battleship")
Then, we have implemented the different classes and fuctions, which we will describe now. We've commented our code, so we want explain every line.

## Main Class:
This is the class, which is excecuted and it uses the other classes to work like the battleship porgram should. 
After greeting the user, it starts to create a new Gameboard (Gameboard()) and it asks to user to fill in the coordniates for each ship.
In the end, it prints out the Gameboard (GameBoard.printBoard(Board)).

## Utils Class:
This class provides the functions cUInputToGameCord() which converts the inserted user input into our gamecoordinates (arrays) and the function validMove() which checks if:
-the ships are diagonal
-out of gameboard
-the length is invalid (for example just two filds for a carrier)
This ensures that the exceptions we had to test are detected.

## ShipI Class:
This idea to solve the program like this is inspired by the lecture. We used this abstract class to ensure that every Ship has a length/name/shortname (C for Carrier). This makes it impossible, that there is a ship without a length for example.
## Ship Class:
The ship class now implements this attributes.
##Gameboard Class:
The gameboard grid is a static variable. With this, it is very easy the write something in the grid or read it. printBoard() prints out the whole grid.

## Move Class:
isFree() checks the gameboard, using the gamecoordinates, if the fields are free. We have made it like that, so we could use this in future: When the game is actually played, you can check if person landed a hit at a ship. printCood() just prints the coordinates. readIn() takes the users input and converts them with cUInputToGameCord(). writeMove() uses to calculate the moves on the board, while makeMove() actually writes them into the board.


-------

# PART 2: UML-Diagram

The following UML class diagram visualizes the classes in ui/util/adapter from the kotcrab project. 
The Visualizationscheme as learned in the lecture has been applied. As no special definition was given for nested classes, we chose to use the default arrow for inner classes. 
![UML](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_2/UML/UML_2.png)
-------
