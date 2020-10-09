import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



public class Main {
    public static void main(String [] args) {

        // PRINT "Welcome to Battleship!!"
        System.out.print("Welcome to Battleship!!");
        System.lineSeparator();

        // INPUT
        // 1x Carrier (6)
        Scanner myObj = new Scanner(System.in);
        String cUInput;
        System.out.print(" Please enter the position of your Carrier: ");
        cUInput = myObj.nextLine();
        Integer [] test = Utils.cUInputToGameCord(cUInput);
        System.out.print(Arrays.toString(test));
        // tests the coordinate, result eg. [A2, B2]

        Move.isFree(test);
        //isFree() check if field is already used

        // Init gameBoard Board
        GameBoard Board = new GameBoard();
        Board.printBoard(Board); //Works

        // Generating all Ships and store them in shipList
        List<Ship> shipList = new ArrayList<Ship>(4);
        for(int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Ship Carrier = new Ship("Carrier",5,"C");
                    shipList.add(Carrier);
                    break;
                case 1:
                    for(int j = 0; j < 2; j++) {
                        Ship Battleship = new Ship("Battleship",4,"B");
                        shipList.add(Battleship);
                    }
                    break;
                case 2:
                    for(int j = 0; j < 3; j++) {
                        Ship Submarine = new Ship("Submarine",3,"B");
                        shipList.add(Submarine);
                    }
                    break;
                case 3:
                    for(int j = 0; j < 4; j++) {
                        Ship PatrolBoat = new Ship("Patrol boat",2,"B");
                        shipList.add(PatrolBoat);
                    }
                    break;
            }
        }

        // Test to access all the attributes of the shipList // works

        System.out.println("###########################################");
        for(Ship ship : shipList) {
            System.out.println(ship.getName() + " has length " + ship.length);
        }


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
