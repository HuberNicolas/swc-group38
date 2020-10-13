import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {

        System.out.println("Welcome to Battleship!!");

        // Init gameBoard Board
        GameBoard Board = new GameBoard();
        GameBoard.printBoard(Board); // Working

        // Generating all Ships and store them in shipList
        List<Ship> shipList = new ArrayList<Ship>(4);
        int shipListIterator = 0;
        for(int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Ship Carrier = new Ship("Carrier",6,"C");
                    shipList.add(Carrier);
                    System.out.print(" Please enter the position of your Carrier: ");
                    Move.makeMove(Board, shipList.get(shipListIterator));
                    shipListIterator++;
                    break;
                case 1:
                    for(int j = 1; j < 3; j++) {
                        Ship Battleship = new Ship("Battleship",4,"B");
                        shipList.add(Battleship);
                        System.out.print(" Please enter the position of your Battleship "+ j +": ");
                        Move.makeMove(Board, shipList.get(shipListIterator));
                        shipListIterator++;
                    }
                    break;
                case 2:
                    for(int j = 1; j < 4; j++) {
                        Ship Submarine = new Ship("Submarine",3,"S");
                        shipList.add(Submarine);
                        System.out.print(" Please enter the position of your Submarine "+ j +": ");
                        Move.makeMove(Board, shipList.get(shipListIterator));
                        shipListIterator++;
                    }
                    break;
                case 3:
                    for(int j = 1; j < 5; j++) {
                        Ship PatrolBoat = new Ship("Patrol boat",2,"P");
                        shipList.add(PatrolBoat);
                        System.out.print(" Please enter the position of your Patrol boat "+ j +": ");
                        Move.makeMove(Board, shipList.get(shipListIterator));
                        shipListIterator++;
                    }
                    break;
            }
        }

        System.lineSeparator(); // ???

        // Test to access all the attributes of the shipList // works
        //System.out.println("###########################################");
        for(Ship ship : shipList) {
            //System.out.println(ship.getName() + " has length " + ship.length);
        }

        System.out.println("Your board is: ");
        GameBoard.printBoard(Board);
    }
}
