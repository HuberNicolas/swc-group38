/**
 * Description:             A 2dim Version of the BATTLESHIP GAME
 * @Authors:                Robin Wassink, Louis Huber and Nicolas Huber
 *
 */

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        System.out.println("Welcome to Battleship!!");
        // Init gameBoard Board
        GameBoard Board = new GameBoard();
        //GameBoard.printBoard(Board); // DEBUG

        // Generating all Ships and store them in shipList
        List<Ship> shipList = new ArrayList<Ship>(4);
        int shipListIterator = 0; // number of all ships, regardless of type
        // Fill shipList / board with 4 types of different ships
        for(int i = 0; i < 4; i++) {
            switch (i) {
                case 0: // CARRIER
                    Ship Carrier = new Ship("Carrier",6,"C");
                    shipList.add(Carrier);
                    while (true) {
                        try { // try to place a ship
                            System.out.print(" Please enter the position of your Carrier: ");
                            Move.makeMove(Board, shipList.get(shipListIterator));
                            shipListIterator++;
                            break;
                        } catch (Exception e) {
                            System.err.println("You cannot place your ship here! " + e.getMessage());
                        }
                    }
                    break;
                case 1: // BATTLESHIP
                    for(int j = 1; j < 3; j++) {
                        Ship Battleship = new Ship("Battleship",4,"B");
                        shipList.add(Battleship);
                        while (true) {
                            try { // try to place a ship
                                System.out.print(" Please enter the position of your Battleship " + j + ": ");
                                Move.makeMove(Board, shipList.get(shipListIterator));
                                shipListIterator++;
                                break;
                            } catch (Exception e) {
                                System.err.println("You cannot place your ship here! " + e.getMessage());
                            }
                        }
                    }
                    break;
                case 2: // SUBMARINE
                    for(int j = 1; j < 4; j++) {
                        Ship Submarine = new Ship("Submarine",3,"S");
                        shipList.add(Submarine);
                        while (true) {
                            try { // try to place a ship
                                System.out.print(" Please enter the position of your Submarine "+ j +": ");
                                Move.makeMove(Board, shipList.get(shipListIterator));
                                shipListIterator++;
                                break;
                            } catch (Exception e) {
                                System.err.println("You cannot place your ship here! " + e.getMessage());
                            }
                        }
                    }
                    break;
                case 3: // PATROL BOAT
                    for(int j = 1; j < 5; j++) {
                        Ship PatrolBoat = new Ship("Patrol boat",2,"P");
                        shipList.add(PatrolBoat);
                        while(true) {
                            try { // try to place a ship
                                System.out.print(" Please enter the position of your Patrol boat "+ j +": ");
                                Move.makeMove(Board, shipList.get(shipListIterator));
                                shipListIterator++;
                                break;
                            } catch (Exception e) {
                                System.err.println("You cannot place your ship here! " + e.getMessage());
                            }
                        }
                    }
                    break;
            }
        }
        /*DEBUG
        // Test to access all the attributes of the shipList // works
        for(Ship ship : shipList) {
        * //System.out.println(ship.getName() + " has length " + ship.length);
        }*/
        GameBoard.printBoard(Board);
    }
}
