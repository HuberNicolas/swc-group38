import java.util.ArrayList;
/**
 * CLASS HUMAN
 * extends the abstract class Player and
 * Models an computer player
 */
public class Computer extends Player {
    Computer(GameBoard board, GameBoard sBoard) {
        Name = "Computer";
        Board = board;
        SBoard = sBoard;
        ShipsAlive = 9;
        ArrayList<Ship> shipList = new ArrayList<Ship>();
    }
}
