import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.*;

/**
 * CLASS Utils
 * Class for utility functions
 */
public class Utils {
    // Singleton
    private static Utils uniqueInstance = new Utils();
    private Utils() {
    }
    public static Utils getInstance() {
        return uniqueInstance;
    }

    /**
     * @param defense Player            player whose ships get shot
     * @param GameCoord Int Array       coordinates of a valid shot
     *
     * Description:                     decrease Hitpoints of a ship after it got hit:
     *                                  - convert coordinates of shot
     *                                  - check for all ships in shipList the attribute coordArray
     *                                  - decrement hp by 1 of the found ship
     */
    static void decreseHP(Player defense, Integer [] GameCoord) {
        Iterator<Ship> iterator = defense.shipList.listIterator();
        while(iterator.hasNext()) {
            Ship s = iterator.next();
            for(int i = 0; i < s.coordArray.length; i++) {
                // convert coordinates from [A1] to A1
                String str1 = Arrays.toString(Utils.ShootCoordtoArray(GameCoord));
                String str2 = str1.replace("[", "");
                String str = str2.replace("]", "");
                // find
                if (s.coordArray[i] != null) {
                    if (s.coordArray[i].equals(str)) {
                        s.lifepoints--; // works
                    }
                }
            }
        }
    }

    /**
     *
     * @param length int                length of a ship that needs to be places
     * @return                          array like [A1,A3], (random position of a ship)
     *
     * Description:                     Random Ship-Placing
     *                                  - takes the length as integer
     *                                  - can be converted with  GameCordtowriteArray()
     */
    static String[] ComputerRand(int length) {
        length = length - 1;
        //transform Input [0, 1, 1, 1] to [A1,B1]
        String[] ComputerRand = new String[2];
        int column = ThreadLocalRandom.current().nextInt(0, 10);
        int row = ThreadLocalRandom.current().nextInt(0, 10);
        ComputerRand[0] = String.valueOf((char) (column + 65)) + row;
        //orientation defines, if the ship is horizontally or vertically placed
        int orientation = ThreadLocalRandom.current().nextInt(1, 3);
        //vertically placed
        if (orientation == 1) {
            //check if there is enough space. if not, the ship is placed backwards
            if (length + column < 10) {
                ComputerRand[1] = String.valueOf((char) (column + length + 65)) + row;
            } else {
                ComputerRand[1] = String.valueOf((char) (column - length + 65)) + row;
            }
        } else {
            //horizontal placed
            //check if there is enough space. if not, the ship is placed backwards
            if (length + row < 10) {
                ComputerRand[1] = String.valueOf((char) (column + 65)) + (row + length);
            } else {
                ComputerRand[1] = String.valueOf((char) (column + 65)) + (row - length);
            }
        }
        return ComputerRand;
    }

    /**
     * @param cUInput: string               userinput for a ship, may needs to be rejected
     * @return Int Array[]                  with 4 coordinates/entries: [x_1,y_1,x_2,y_2]
     *
     * Description:                         This method translates the checks the userinput for a ship and
     *                                      converts it into the format [x_1,y_1,x_2,y_2]
     */
    static Integer[] cUInputToGameCord(String cUInput) {
        //transform Input "A1 B1" to [0, 1, 1, 1]
        Integer[] Gamecord = new Integer[4];
        //Check if length is correct
        if (cUInput.length() != 5) {
            throw new IllegalArgumentException("Input has not correct length! Example: 'A1 B2'");
        }
        Gamecord[0] = cUInput.charAt(0) - (int) 'A';
        Gamecord[1] = cUInput.charAt(1) - 48;
        Gamecord[2] = cUInput.charAt(3) - (int) 'A';
        Gamecord[3] = cUInput.charAt(4) - 48;
        return Gamecord;
    }

    /**
     * @param cUInput: string               userinput for a shot, may needs to be rejected
     * @return Int Array[]                  with 2 coordinates/entries: [x_1,y_1]
     *
     * Description:                         This method translates the checks the userinput for a shot and
     *                                      converts it into the format [x_1,y_1]
     */
    static Integer[] cUInputToShotCord(String cUInput) {
        //transform Input "A1" to [0, 1]
        Integer[] Gamecord = new Integer[2];
        //Check if length is correct
        if (cUInput.length() != 2) {
            throw new IllegalArgumentException("Input has not correct length! Example: 'A1'");
        }
        Gamecord[0] = cUInput.charAt(1) - 48;
        Gamecord[1] = cUInput.charAt(0) - (int) 'A';
        return Gamecord;
    }

    /**
     * @param ShootCoord Int[]              Integer Array for a shot eg. [1,2]
     * @return String Array[]               with 2 coordinates/entries: [x_1,y_1]
     *
     * Description:                         This method converts the userinput for a shot from
     *                                      [1,2] to C1.
     */
    static String[] ShootCoordtoArray(Integer[] ShootCoord) {
        // transform Input {1,2} to [C1]
        String[] ShootArray = new String[1];
        int letter = ShootCoord[1];
        //System.out.println(letter);
        //System.out.println((char) (letter+65));
        ShootArray[0] = String.valueOf((char) (letter + 65)) + (ShootCoord[0]);
        return ShootArray;
    }

    /**
     * @param Gamecord int Arr[]                   the entered coordinates of a ship, that need to be checked.
     *                                              (4 entries : [x_1,y_1,x_2,y_2])
     *
     * @return                                      string array for the coordinates of a ship
     * Description:                                 transform Input [0, 1, 1, 1] to [A1,B1]
     */
    static String[] GameCordtowriteArray(Integer[] Gamecord) {
        //tansform Input [0, 1, 1, 1] to [A1,B1]
        String[] GamecordArray = new String[6];
        int difference = 0;
        int j = 0;
        // [x1,y1,x2,y2] -> vertical
        if (Gamecord[0] != Gamecord[2]) {
            difference = Math.abs(Gamecord[2] - Gamecord[0]);
            for (int i = 0; i < difference + 1; i++) {
                int value = Math.min(Gamecord[0], Gamecord[2]) + i;
                GamecordArray[i] = String.valueOf((char) (value + 65)) + Gamecord[1];
                //GamecordArray[i]=((char)(Gamecord[0]+Integer.toString(i)))+Gamecord[1];
                //System.out.print(GamecordArray[i]);
            }
        } else {
            // horizontal
            //for example: [1, 0, 1, 1] to [B0,B1]
            difference = Math.abs(Gamecord[3] - Gamecord[1]);
            for (int i = 0; i < difference + 1; i++) {
                int value = Math.min(Gamecord[1], Gamecord[3]) + i;
                GamecordArray[i] = String.valueOf((char) (Gamecord[0] + 65)) + value;
                //System.out.print(GamecordArray[i]);
            }
        }
        return GamecordArray;
    }

    /**
     * @param Gamecoord int Arr[]                   the entered coordinates of a ship, that need to be checked.
     *                                              (4 entries : [x_1,y_1,x_2,y_2])
     * @param sN String                             length of the to be placed ship
     * @param len int                               shortname for the to be placed ship
     *
     * @return Description:                         This method checks, if the user made a valid move:
     *                                              - ship is not diagonal
     *                                              - ship is not out of field
     *                                              - ship has the correct length
     */
    static boolean validMove(Integer[] Gamecoord, String sN, Integer len, Player p) {
        //check if horizontal or vertical -> no diagonal possible
        if (Gamecoord[0] != Gamecoord[2] && Gamecoord[1] != Gamecoord[3]) {
            throw new IllegalArgumentException("No diagonal ships allowed");
        }
        //check if out of field
        if (Gamecoord[0] < 0 || Gamecoord[1] < 0 || Gamecoord[2] < 0 || Gamecoord[3] < 0 || Gamecoord[0] > 10 || Gamecoord[1] > 10 || Gamecoord[2] > 10 || Gamecoord[3] > 10) {
            throw new IllegalArgumentException("Out of Gameboard");
        }
        //check if length of ship is valid
        if (Math.abs(Gamecoord[0] - Gamecoord[2]) != (len - 1) && Math.abs(Gamecoord[1] - Gamecoord[3]) != (len - 1)) {
            throw new IllegalArgumentException("Invalid length of Ship");
        }
        if (Gamecoord[0] == Gamecoord[2]) {
            for (int i = Math.min(Gamecoord[1], Gamecoord[3]); i <= Math.max(Gamecoord[1], Gamecoord[3]); i++) {
                // check if empty
                if (p.Board.grid[i][Gamecoord[0]] != " ") {
                    throw new IllegalArgumentException("There is already a ship placed");
                }
            }
            return true;
        }
        if (Gamecoord[1] == Gamecoord[3]) {
            for (int i = Math.min(Gamecoord[0], Gamecoord[2]); i <= Math.max(Gamecoord[0], Gamecoord[2]); i++) {
                // check if empty
                if (p.Board.grid[Gamecoord[1]][i] != " ") {
                    throw new IllegalArgumentException("There is already a ship placed");
                }
            }
            return true;
        }
        else return true;
    }

    /**
     * @param attack Player:                        player who shoots
     * @param defense Player                        player whose ships get shot
     * @param Gamecoord int Arr[]                   the entered coordinates of a shot, that need to be checked.
     *                                              (2 entries : [x_1,y_1])
     *
     * @return Description:                         This method checks, if the user made a valid shot:
     *                                              - shot is not out of field
     *                                              - not already shot
     */
    static boolean validShot(Player attack, Player defense,  Integer [] Gamecoord) {
        //check if out of field
        if (Gamecoord[0] < 0 || Gamecoord[1] < 0  || Gamecoord[0] > 10 || Gamecoord[1] > 10) {
            throw new IllegalArgumentException("Out of Gameboard");
        }
        if(attack.SBoard.grid[Gamecoord[0]][Gamecoord[1]] == "x" || attack.SBoard.grid[Gamecoord[0]][Gamecoord[1]] == "o") {
            throw new IllegalArgumentException("Already Shot!");
        }
        if (attack instanceof Human){
            if(attack.SBoard.grid[Gamecoord[0]][Gamecoord[1]] != " ") {
                throw new IllegalArgumentException("Already Shot!");
            }
            return true;
        }
        else return true;
    }

    /**
     *
     * @param coordArray String []          CoordArray of a ship type String [A1, A2, A3, A4, A5, A6]
     * @return Integer []                   CoordArray of a ship type Int [] [x1,y1,x2,y2]
     *
     * Description:                         Takes String [] and return Gamecoord for example:
     *                                      ["E8", "F8","G8", null, null, null,null,null]
     *                                      returns [4, 8, 6, 8]
     */
    static Integer[] writeShotShips(String [] coordArray) {
        Integer[] writeShotShipsArray = new Integer[4];
        int i;
        int x=5;
        //delete null entries
        for (i = 0; i < coordArray.length; i++) {
            if (coordArray[i]== null){
                x=i-1;
                break;
            }
        }
        //System.out.println(x);
        //create new array without null and correct size
        String[] coordArraywithoutnull = new String[x+1];
        System.arraycopy(coordArray, 0, coordArraywithoutnull, 0,x+1);
        //System.out.println(Arrays.toString(coordArraywithoutnull)); DEBUG
        String FirstCoord = coordArraywithoutnull[0];
        String LastCoord = coordArraywithoutnull[x];
        writeShotShipsArray[0] = FirstCoord.charAt(0) - (int) 'A';
        writeShotShipsArray[1] = FirstCoord.charAt(1) - 48;
        writeShotShipsArray[2] = LastCoord.charAt(0) - (int) 'A';
        writeShotShipsArray[3] = LastCoord.charAt(1) - 48;
        return writeShotShipsArray;
    }
}