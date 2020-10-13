import java.util.Scanner;



public class Move {
    static void  isFreeL(Integer [] Gamecord){
       if (GameBoard.grid[0][0]== "S")
       {
           System.out.print("Success");
       }
        System.out.print(Gamecord);
    }
    static boolean  isFree(Integer [] Gamecord){
        if (GameBoard.grid[0][0] == " ") return true;
        else return false;
    }

    static void printCood(Integer [] CList) {
        System.out.println("["+CList[0]+","+CList[1]+","+CList[2]+","+CList[3]+"]");
    }

    static Integer [] readIn(String sN){
        // BUG: e.g. "F10" will be interpreted as "F1"

        Scanner myObj = new Scanner(System.in);
        String cUInput;
        //System.out.print(" Please enter the position of your Carrier: ");
        cUInput = myObj.nextLine();
        Integer [] coord = Utils.cUInputToGameCord(cUInput);
        printCood(coord); // for debugging
        return coord;
    }

    static void writeMove(GameBoard board, String sN, Integer [] coord) {

        // Letters are the same (vertical)
        if (coord[0] == coord[2]) {
            for(int i = Math.min(coord[1],coord[3]); i <= Math.max(coord[1],coord[3]); i++) {
                GameBoard.grid[i][coord[0]] = sN;
            }
        }
        // Numbers are the same (horizontal) (could NOT be removed) UPDATE: WE NEED THIS
        if (coord[1] == coord[3]) {
            for(int i = Math.min(coord[0],coord[2]); i <= Math.max(coord[0],coord[2]); i++) {
                GameBoard.grid[coord[1]][i] = sN;
            }
        }
    }

    static void makeMove(GameBoard board, Ship s) {
        Integer [] coord = readIn(s.shortName);
        if (!Utils.validMove(coord, s.shortName, s.length)) {
            System.out.println("This was not a valid move, please try again");
        }
        else writeMove(board, s.shortName, coord);

    }

}
