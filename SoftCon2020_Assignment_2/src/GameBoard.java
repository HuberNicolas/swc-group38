public class GameBoard {
    static String [][] grid = {
                               // A   B   C   D   E   F   G   H   I   J
                                {"S"," "," "," "," "," "," "," "," "," "}, //Row 0
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "},
                                {" "," "," "," "," "," "," "," "," "," "}}; //Row 9

    static void printBoard(GameBoard board) {
        System.out.println("\n");
        System.out.println("Your board is:\n");
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
