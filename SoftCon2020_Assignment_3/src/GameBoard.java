/**
 * CLASS GameBoard
 * Implements the actual datastructure (2dim Array [][]) for the board which stores the ships.
 */
public class GameBoard {
    String [][] grid;
    public GameBoard() {
        this.grid = new String[][]{
                // A   B   C   D   E   F   G   H   I   J
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //Row 0
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}}; //Row 9
    }

    /**
     * @param p Player:                player
     *
     * Description:                    prints player p board with the ships (p.Board)
     */
    static void printGameBoard(Player p) {
        //System.out.println("\n");
        System.out.println("\nYour board is:\n");
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]");
        System.out.println("---|------------------------------");
        for (int row = 0; row < p.Board.grid.length; row++) {
            // header with number
            System.out.print("[" + row + "]" + "|");
            for (int col = 0; col < p.Board.grid[row].length; col++) {
                System.out.print("[" + p.Board.grid[row][col] + "]");
            }
            System.out.println();
        }
    }
}