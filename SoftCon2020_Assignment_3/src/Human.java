import java.util.ArrayList;

public class Human extends Player {
    Human(GameBoard board, GameBoard sBoard) {
        Board = board;
        SBoard = sBoard;
        ShipsAlive = 9;
        ArrayList<Ship> shipList = new ArrayList<Ship>();
    }
}
