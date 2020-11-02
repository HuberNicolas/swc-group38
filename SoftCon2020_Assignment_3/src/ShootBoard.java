/**
 * CLASS ShootBoard
 * Implements the actual datastructure (2dim Array [][]) for the board which stores all shooting entries.
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
     * @param p Player:                player
     *
     * Description:                    prints player p board with the shooting entries (p.SBoard)
     */
    static void printShootBoard(Player p) {
        //System.out.println("\n");
        System.out.println("\nThe opponent's board is:\n");
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]");
        System.out.println("---|------------------------------");
        for (int row = 0; row < p.SBoard.grid.length; row++) {
            // header with number
            System.out.print("[" + row + "]" + "|");
            for (int col = 0; col < p.SBoard.grid[row].length; col++) {
                System.out.print("[" + p.SBoard.grid[row][col] + "]");
            }
            System.out.println();
        }
    }
}
