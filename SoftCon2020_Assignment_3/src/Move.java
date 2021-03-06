import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
/**
 * CLASS MOVE
 * Class for implementing the actual GameMove methods: A game move is
 *      - placing a ship
 *      - shooting on a ship
 */
public class Move {
    /**
     * @param board GameBoard:              board of player
     * @param GameCoord Int Array[]:        2 entries [x,y]
     * @return                              true, if GameBoard "board" at the coord. "GameCoord" has no entity := " "
     */
    static boolean  isFree(GameBoard board, Integer [] GameCoord){
        if (board.grid[GameCoord[0]][GameCoord[1]] == " ") return true;
        else return false;
    }

    /**
     * @param attack Player:                player who shoots
     * @param defense Player:               player whose ships get shot
     *
     * Description:                         Helper function to invoke the makeShot function
     */
    static void shooting(Player attack, Player defense) {
        while (true) {
            try { // check whether the coordinates are valid
                if (attack instanceof Human) {
                    System.out.print("Enter the position you want to attack: ");
                }
                Move.makeShot(attack, defense);
                break;
            } catch (Exception e) {
                if (attack instanceof Human) {
                    System.err.println("You cannot shoot! " + e.getMessage());
                }
                if (attack instanceof Computer) {
                    continue;
                }
            }
        }
    }

    /**
     * @param attack Player:                player who shoots
     * @param defense Player:               player whose ships get shot
     *
     *
     * Description:                         Helper function:
     *                                      Reads the coordinates for a shot in (eg. A4),
     *                                      Checks them with valid(shot)
     *                                      Invokes the actual shoot method
     */
    static void makeShot(Player attack, Player defense) {
        if (attack instanceof Human) {
            Integer[] coord = readInShot();
            // as long as we do not have a valid move; throw Exception and repeat!
            if (!Utils.validShot(attack, defense, coord)) {
                System.out.println("This was not a valid move, please try again");
            }
            else shoot(attack, defense, coord);
        }
        else {
            String shotGen = Arrays.toString(Utils.ComputerRand(1)).substring(1,3); // e.g. J5
            Integer [] coord = Utils.cUInputToShotCord(shotGen);
            if (!Utils.validShot(attack, defense, coord)) {
                //System.out.println("This was not a valid move, please try again");
            }
            else {
                System.out.println("The computer attacks position " + shotGen);
                shoot(attack, defense, coord);
            }
        }
    }

    /**
     * @param attack Player:                player who shoots
     * @param defense Player:               player whose ships get shot
     * @param GameCoord Int Array           generated shoot coordinates eg. [0,1]
     *
     * Description:                         Helper function
     *                                      Checks them with valid(shot)
     *                                      Invokes the actual shoot method
     */
    static void shoot(Player attack, Player defense,  Integer [] GameCoord) {
        Ship ship = null;
        // check if is a ship
        if(isFree(defense.Board, GameCoord)) {
            // hit nothing
            attack.SBoard.grid[GameCoord[0]][GameCoord[1]] = "o";
            if (attack instanceof Human){
                System.out.println("Miss");
            }
            else System.out.println("The computer missed\n");
        }

        else {
            // hit something
            attack.SBoard.grid[GameCoord[0]][GameCoord[1]] = "x";
            Iterator<Ship> iterator = defense.shipList.listIterator(); // find ship which was hit on the defense board
            Utils.decreseHP(defense, GameCoord); // decrease hp of ship
            // find ship via iterator
            while(iterator.hasNext()) {
                Ship s = (Ship)iterator.next();
                // is ship sunk?
                if(s.lifepoints == 0) {
                    if (defense instanceof Computer){
                        Integer [] arr = Utils.writeShotShips(s.coordArray);
                        writeMove(attack.SBoard, s.shortName, arr); // only write for humans eyes
                    }
                    defense.ShipsAlive--;
                    ship = s;
                }
            }
            if (ship != null){
                if (attack instanceof Human){
                    System.out.println("You destroyed a " + ship.name + ".");
                }
                else System.out.println("Your "+ ship.name + " was destroyed\n");
                defense.shipList.remove(ship);
            }
            else{
                if (attack instanceof Human){
                    System.out.println("You hit a boat!");
                }
                else System.out.println("Your boat was hit!\n");
                //normal hit message
            }
        }
        // ShootBoard.printShootBoard(attack); DEBUG
    }

    /**
     * @param CList Int Array[]:            4 entries [x_1,y_1,x_2,y_2]
     * OUTPUT:                              prints coordinates of a ship; helper function and for debugging
     */
    static void printCood(Integer [] CList) {
        System.out.println("["+CList[0]+","+CList[1]+","+CList[2]+","+CList[3]+"]");
    }

    /**
     * @return Int Array[] "coord":         4 entries [x_1,y_1,x_2,y_2], which are the coordinates for the new Ship
     */
    static Integer [] readIn(){
        Scanner myObj = new Scanner(System.in);
        String cUInput;
        cUInput = myObj.nextLine();
        Integer [] coord = Utils.cUInputToGameCord(cUInput);
        //printCood(coord); // DEBUG
        return coord;
    }

    /**
     * @return Int Array[] "coord":         2 entries [x_1,y_1], which are the coordinates for the new shot
     */
    static Integer [] readInShot() {
        Scanner myObj = new Scanner(System.in);
        String cUInput;
        cUInput = myObj.nextLine();
        Integer [] coord = Utils.cUInputToShotCord(cUInput);
        //printCood(coord); // DEBUG
        return coord;
    }

    /**
     *
     * @param board GameBoard "board":      actual GameBoard
     * @param sN String "sN":               shortname for the to be placed ship
     * @param coord Int Array[]:            the entered coordinates
     *
     * Description:                         This method checks (is there no other entity), if a ship of type "sN"
     *                                      can be placed at the coord "coord" on the GameBoard "board".
     *                                      If yes, it actually places ("writes") the ship there.
     */
    static void writeMove(GameBoard board, String sN, Integer [] coord) {
        // Letters are the same (vertical)
        if (coord[0] == coord[2]) {
            for(int i = Math.min(coord[1],coord[3]); i <= Math.max(coord[1],coord[3]); i++) {
                board.grid[i][coord[0]] = sN; // write
            }
        }
        // Numbers are the same (horizontal) (could NOT be removed) UPDATE: WE NEED THIS
        if (coord[1] == coord[3]) {
            for(int i = Math.min(coord[0],coord[2]); i <= Math.max(coord[0],coord[2]); i++) {
                board.grid[coord[1]][i] = sN; // write
            }
        }
    }

    /**
     *
     * @param s Ship:                       an object of class "Ship" out of the "shipList"
     * Description:                         This method checks initiates the actual ship-placing-process (move):
     *                                      - user enters coords for the ship "s" in "shipList"
     *                                      - method checks, if this is a valid user input
     */
    static void makeMove(Ship s, Player p) {
        if (p instanceof Human) {
            Integer [] coord = readIn();
            // as long as we do not have a valid move; throw Exception and repeat!
            if (!Utils.validMove(coord, s.shortName, s.length, p)) {
                System.out.println("This was not a valid move, please try again");
            }
            // we have a valid move; write it to the gameBoard
            else {
                s.coordArray = Utils.GameCordtowriteArray(coord);
                writeMove(p.Board, s.shortName, coord);
            }
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
                    s.coordArray = Utils.GameCordtowriteArray(coord);
                    writeMove(p.Board, s.shortName, coord);
                } catch (Exception e) {
                }
                //GameBoard.printBoard(p.Board);
            }
        }
    }

    /**
     *
     * @param p Player:                player who places the ships
     *
     * Description:                     initialises game with placing all ships on p.Board
     */
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
                            if (p instanceof Human) {
                                System.err.println("You cannot place your ship here! " + e.getMessage());
                            }
                            if (p instanceof Computer) {
                                continue;
                            }
                        }
                    }
                    break;
                case 1: // BATTLESHIP
                    for(int j = 1; j < 3; j++) {
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
                                if (p instanceof Human) {
                                    System.err.println("You cannot place your ship here! " + e.getMessage());
                                }
                                if (p instanceof Computer) {
                                    continue;
                                }
                            }
                        }
                    }
                    break;
                case 2: // SUBMARINE
                    for(int j = 1; j < 4; j++) {
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
                                if (p instanceof Human) {
                                    System.err.println("You cannot place your ship here! " + e.getMessage());
                                }
                                if (p instanceof Computer) {
                                    continue;
                                }
                            }
                        }
                    }
                    break;
                case 3: // PATROL BOAT
                    for(int j = 1; j < 5; j++) {
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
                                if (p instanceof Human) {
                                    System.err.println("You cannot place your ship here! " + e.getMessage());
                                }
                                if (p instanceof Computer) {
                                    continue;
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }
}
