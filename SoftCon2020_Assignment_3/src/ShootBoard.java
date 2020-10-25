/**
        * CLASS ShootBoard
        * Implements the actual datastructure (2dim Array [][]) for the board.
        *Very similar to GameBoard but not Singleton -> we need two Shootbards
        */
public class ShootBoard {
    static String [][] grid = {
            // A   B   C   D   E   F   G   H   I   J
            {" "," "," "," "," "," "," "," "," "," "}, //Row 0
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "," "," "}}; //Row 9

    /**
     *
     * @param board ShootBoard "board":  2dim Array [][] structure; representing the Battleship matchfield
     * INPUT:                           GameBoard "board"
     * OUT  :                           prints GameBoard "board"
     */

    static void printBoard(ShootBoard board) {
        //System.out.println("\n");
        System.out.println("\nYour board is:\n");
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]");
        System.out.println("---|------------------------------");
        for (int row = 0; row < grid.length; row++) {
            // header with number
            System.out.print("[" + row + "]" + "|");
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print("[" + grid[row][col] + "]");
            }
            System.out.println();
        }
    }

}
