import java.util.ArrayList;
/**
 * CLASS HUMAN
 * extends the abstract class Player and
 * Models an human player
 */
public class Human extends Player {
    Human(GameBoard board, GameBoard sBoard) {
        Name = "Human";
        Board = board;
        SBoard = sBoard;
        ShipsAlive = 9;
        ArrayList<Ship> shipList = new ArrayList<Ship>();
    }
}
