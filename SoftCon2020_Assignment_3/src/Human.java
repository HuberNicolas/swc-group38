public class Human extends Player {

    public GameBoard Board;
    public ShootBoard SBoard;
    Integer ShipsAlive;

    Human(GameBoard board, ShootBoard sBoard) {
        Board = board;
        SBoard = sBoard;
        ShipsAlive = 9;
    }



}
