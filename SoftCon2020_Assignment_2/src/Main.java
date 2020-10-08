import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String [] args) {

        // PRINT "Welcome to Battleship!!"
        System.out.print("Welcome to Battleship!!");
        System.lineSeparator();

        GameBoard Board = new GameBoard();
        Board.printBoard(Board); //Works


        /* To Test te Print function
            // INPUT
            // 1x Carrier (6)
            Scanner myObj = new Scanner(System.in);
            String cUInput;
            System.out.print(" Please enter the position of your Carrier: ");
            cUInput = myObj.nextLine();
            String [] test = Utils.cUInputToGameCord(cUInput);
            System.out.print(Arrays.toString(test));
            // tests the coordinate, result eg. [A2, B2]
        */

        // 2x Battleship (4)
        // 3x Submarine (3)
        // 4x Patrol Boat (2)


        // OUTPUT

        // PRINT "Your board is:"
        // printBoard(gameBoard Board)


    }
}
