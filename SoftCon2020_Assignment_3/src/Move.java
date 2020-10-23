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
    static boolean  isFree(Integer [] GameCoord){
        if (GameBoard.grid[GameCoord[0]][GameCoord[1]] == " ") return true;
        else return false;
    }

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
                if (GameBoard.grid[i][coord[0]] != " ") throw new IllegalArgumentException("There is already a ship placed");
                else GameBoard.grid[i][coord[0]] = sN; // write
            }
        }
        // Numbers are the same (horizontal) (could NOT be removed) UPDATE: WE NEED THIS
        if (coord[1] == coord[3]) {
            for(int i = Math.min(coord[0],coord[2]); i <= Math.max(coord[0],coord[2]); i++) {
                // check if empty
                if (GameBoard.grid[coord[1]][i] != " ") throw new IllegalArgumentException("There is already a ship placed");
                else GameBoard.grid[coord[1]][i] = sN; // write
            }
        }
    }

    /**
     *
     * @param board GameBoard "board":      actual gameboard
     * @param s Ship "s":                   an object of class "Ship" out of the "shipList"
     * Discription:                         This method checks initiates the actual ship-placing-process (move):
     *                                      - user enters coords for the ship "s" in "shipList"
     *                                      - method checks, if this is a valid user input
     *                                      - if so; write it to "board"
     */
    static void makeMove(GameBoard board, Ship s) {
        // users needs to enter coordinates
        Integer [] coord = readIn(s.shortName);
        // as long as we do not have a valid move; throw Exception and repeat!
        if (!Utils.validMove(coord, s.shortName, s.length)) {
            System.out.println("This was not a valid move, please try again");
        }
        // we have a valid move; write it to the gameBoard
        else {
            writeMove(board, s.shortName, coord);
            //update ship coordinates
            //coord.s.ship=Utils.GameCordtowriteArray(Gamecoord);
        }
    }
}
