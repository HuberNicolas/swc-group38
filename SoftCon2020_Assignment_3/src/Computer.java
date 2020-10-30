import java.util.ArrayList;
import java.util.List;

public class Computer extends Player {
    public GameBoard Board;
    public ShootBoard SBoard;
    Integer ShipsAlive;


    Computer(GameBoard board, ShootBoard sBoard) {
        Board = board;
        SBoard = sBoard;
        ShipsAlive = 10;
    }
}
