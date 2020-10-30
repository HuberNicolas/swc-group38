import java.util.ArrayList;
import java.util.List;

public class Computer extends Player {

    Computer(GameBoard board, ShootBoard sBoard) {
        Board = board;
        SBoard = sBoard;
        ShipsAlive = 10;
    }
}
