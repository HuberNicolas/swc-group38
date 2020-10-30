import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * CLASS MOVE
 * Class for implementing the actual GameMove methods: A game move is
 *      - placing a ship
 *      - shooting on a ship
 */
public class Move {
    /**
     * @param GameCoord Int Array[]:        2 entries [x,y]
     * @return                              true, if GameBoard "board" at the coord. "GameCoord" has no entity := " "
     */
    // for later tasks; Not fully tested
    /* EDIT LATER
    static boolean  isFree(Integer [] GameCoord){
        if (GameBoard.grid[GameCoord[0]][GameCoord[1]] == " ") return true;
        else return false;
    }
    */


    /**
     * @param CList Int Array[]:            4 entries [x_1,y_1,x_2,y_2]
     * OUTPUT:                              prints coordinates of a ship; helper function and for debugging
     */
    static void printCood(Integer [] CList) {
        System.out.println("["+CList[0]+","+CList[1]+","+CList[2]+","+CList[3]+"]");
    }

    /**
     *
     * @param sN String "sN":               attribute "ShortName" for an Obj. of the "Ship" class
     * @return Int Array[] "coord":         4 entries [x_1,y_1,x_2,y_2], which are the coordinates for the new Ship
     */
    static Integer [] readIn(String sN){
        Scanner myObj = new Scanner(System.in);
        String cUInput;
        cUInput = myObj.nextLine();
        Integer [] coord = Utils.cUInputToGameCord(cUInput);
        //printCood(coord); // DEBUG
        return coord;
    }

    /**
     *
     * @param board GameBoard "board":      actual GameBoard
     * @param sN String "sN":               shortname for the to be placed ship
     * @param coord Int Array[]:            the entered coordinates
     *
     * Discription:                         This method checks (is there no other entity), if a ship of type "sN"
     *                                      can be placed at the coord "coord" on the GameBoard "board".
     *                                      If yes, it actually places ("writes") the ship there.
     */
    static void writeMove(GameBoard board, String sN, Integer [] coord) {
        // Letters are the same (vertical)
        if (coord[0] == coord[2]) {
            for(int i = Math.min(coord[1],coord[3]); i <= Math.max(coord[1],coord[3]); i++) {
                // check if empty
                if (board.grid[i][coord[0]] != " ") throw new IllegalArgumentException("There is already a ship placed");
                else board.grid[i][coord[0]] = sN; // write
            }
        }
        // Numbers are the same (horizontal) (could NOT be removed) UPDATE: WE NEED THIS
        if (coord[1] == coord[3]) {
            for(int i = Math.min(coord[0],coord[2]); i <= Math.max(coord[0],coord[2]); i++) {
                // check if empty
                if (board.grid[coord[1]][i] != " ") throw new IllegalArgumentException("There is already a ship placed");
                else board.grid[coord[1]][i] = sN; // write
            }
        }
    }

    /**
     *
     * @param s Ship "s":                   an object of class "Ship" out of the "shipList"
     * Discription:                         This method checks initiates the actual ship-placing-process (move):
     *                                      - user enters coords for the ship "s" in "shipList"
     *                                      - method checks, if this is a valid user input
     */
    static void makeMove(Ship s, Player p) {
        if (p instanceof Human) {
            Integer [] coord = readIn(s.shortName);
            // as long as we do not have a valid move; throw Exception and repeat!
            if (!Utils.validMove(coord, s.shortName, s.length, p)) {
                System.out.println("This was not a valid move, please try again");
            }
            // we have a valid move; write it to the gameBoard
            else writeMove(p.Board, s.shortName, coord);
            // INSERT****
        }
        else {
            String[] ComputerRand = Utils.ComputerRand(s.length);
            String randomInput = ComputerRand.toString();
            String scoord = ""; // stands for string coordinates "G0 G4"
            scoord += Arrays.toString(ComputerRand).charAt(1);
            scoord += Arrays.toString(ComputerRand).charAt(2);
            scoord += Arrays.toString(ComputerRand).charAt(4);
            scoord += Arrays.toString(ComputerRand).charAt(5);
            scoord += Arrays.toString(ComputerRand).charAt(6);
            //System.out.println(scoord);
            Integer [] coord = Utils.cUInputToGameCord(scoord);
            if (!Utils.validMove(coord, s.shortName, s.length, p)) {

            }
            else {
                try {
                    writeMove(p.Board, s.shortName, coord);
                } catch (Exception e) {

                }
                //GameBoard.printBoard(p.Board);

            }
        }
    }

    static void placingShips(Player p) {
        //GameBoard.printBoard(Board); // DEBUG
        // Generating all Ships and store them in shipList
        p.shipList = new ArrayList<Ship>(10);
        int ID_counter=1;
        int shipListIterator = 0; // number of all ships, regardless of type
        // Fill shipList / board with 4 types of different ships

        //Move.placingShips();
        for(int i = 0; i < 4; i++) {
            switch (i) {
                case 0: // CARRIER
                    Ship Carrier = new Ship("Carrier",6,"C",ID_counter,new String[]{"example"},"Player",6,true);
                    p.shipList.add(Carrier);
                    while (true) {
                        try { // try to place a ship
                            if (p instanceof Human) {
                                System.out.print(" Please enter the position of your Carrier: ");
                            }
                            Move.makeMove(p.shipList.get(shipListIterator), p);
                            shipListIterator++;
                            ID_counter=ID_counter+1;
                            break;
                        } catch (Exception e) {
                            if (p instanceof Human || p instanceof Computer) {
                                System.err.println("You cannot place your ship here! " + e.getMessage());
                            }
                        }
                    }
                    break;
                case 1: // BATTLESHIP
                    for(int j = 1; j < 2; j++) {
                        Ship Battleship = new Ship("Battleship",4,"B",ID_counter,new String[]{"example"},"Player",4,true);
                        p.shipList.add(Battleship);
                        while (true) {
                            try { // try to place a ship
                                if (p instanceof Human) {
                                    System.out.print(" Please enter the position of your Battleship " + j + ": ");
                                }
                                Move.makeMove(p.shipList.get(shipListIterator), p);
                                shipListIterator++;
                                ID_counter=ID_counter+1;
                                break;
                            } catch (Exception e) {
                                if (p instanceof Human || p instanceof Computer) {
                                    System.err.println("You cannot place your ship here! " + e.getMessage());
                                }
                            }
                        }
                    }
                    break;
                case 2: // SUBMARINE
                    for(int j = 1; j < 2; j++) {
                        Ship Submarine = new Ship("Submarine",3,"S",ID_counter,new String[]{"example"},"Player",3,true);
                        p.shipList.add(Submarine);
                        while (true) {
                            try { // try to place a ship
                                if (p instanceof Human) {
                                    System.out.print(" Please enter the position of your Submarine " + j + ": ");
                                }
                                Move.makeMove(p.shipList.get(shipListIterator), p);
                                shipListIterator++;
                                ID_counter=ID_counter+1;
                                break;
                            } catch (Exception e) {
                                if (p instanceof Human || p instanceof Computer) {
                                    System.err.println("You cannot place your ship here! " + e.getMessage());
                                }
                            }
                        }
                    }
                    break;
                case 3: // PATROL BOAT
                    for(int j = 1; j < 2; j++) {
                        Ship PatrolBoat = new Ship("Patrol boat",2,"P",ID_counter,new String[]{"example"},"Player",2,true);
                        p.shipList.add(PatrolBoat);
                        while(true) {
                            try { // try to place a ship
                                if (p instanceof Human) {
                                    System.out.print(" Please enter the position of your Patrol boat " + j + ": ");
                                }
                                Move.makeMove(p.shipList.get(shipListIterator), p);
                                shipListIterator++;
                                ID_counter=ID_counter+1;
                                break;
                            } catch (Exception e) {
                                if (p instanceof Human || p instanceof Computer) {
                                    System.err.println("You cannot place your ship here! " + e.getMessage());
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }
}
