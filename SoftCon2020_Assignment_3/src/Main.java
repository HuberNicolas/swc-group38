/**
 * Description:             A 2dim Version of the BATTLESHIP GAME
 * @Authors:                Robin Wassink, Louis Huber and Nicolas Huber
 *
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;

public class Main {

    public static void main(String [] args) {
        // INITIALISATION:
        System.out.println("Welcome to Battleship!!");
        // Init gameBoard Board
        GameBoard humanGameBoard = new GameBoard();
        GameBoard computerGameBoard = new GameBoard();
        Human Human = new Human(humanGameBoard, new GameBoard());
        Computer Computer = new Computer(computerGameBoard, humanGameBoard);
        // Init Checker for the game status with the observer
        ScoreboardChecker ScoreboardChecker = new ScoreboardChecker();
        ScoreboardObserver observer1 = new ScoreboardObserver(ScoreboardChecker);
        // Placing Ships
        Move.placingShips(Human);
        Move.placingShips(Computer);
        // Print both Human boards
        GameBoard.printGameBoard(Human);
        ShootBoard.printShootBoard(Human);
        ScoreboardChecker.checkStatus(Human, Computer);
        ScoreboardChecker.printScoreboard();
        //GameBoard.printGameBoard(Computer); DEBUG

        /* DEBUG: manual initialisation of HUMAN
        // Move.placingShips(Human);
        int ID_counter = 1;
        Human.shipList = new ArrayList<Ship>(10);
        Ship Carrier = new Ship("Carrier",6,"C",ID_counter,new String[]{"example"},"Player",6,true);
        Human.shipList.add(Carrier);
        ID_counter++;
        for (int j = 1; j < 3; j++) {
            Ship Battleship = new Ship("Battleship", 4, "B", ID_counter, new String[]{"example"}, "Player", 4, true);
            Human.shipList.add(Battleship);
            ID_counter++;
        }
        for(int j = 1; j < 4; j++) {
            Ship Submarine = new Ship("Submarine", 3, "S", ID_counter, new String[]{"example"}, "Player", 3, true);
            Human.shipList.add(Submarine);
            ID_counter++;
        }
        for(int j = 1; j < 5; j++) {
            Ship PatrolBoat = new Ship("Patrol boat", 2, "P", ID_counter, new String[]{"example"}, "Player", 2, true);
            Human.shipList.add(PatrolBoat);
            ID_counter++;
        }

        Human.shipList.get(0).coordArray= new String[]{"A0 A5"};
        Human.shipList.get(1).coordArray= new String[]{"B0 B3"};
        Human.shipList.get(2).coordArray= new String[]{"C0 C3"};
        Human.shipList.get(3).coordArray= new String[]{"D0 D2"};
        Human.shipList.get(4).coordArray= new String[]{"E0 E2"};
        Human.shipList.get(5).coordArray= new String[]{"F0 F2"};
        Human.shipList.get(6).coordArray= new String[]{"G0 G1"};
        Human.shipList.get(7).coordArray= new String[]{"H0 H1"};
        Human.shipList.get(8).coordArray= new String[]{"I0 I1"};
        Human.shipList.get(9).coordArray= new String[]{"J0 J1"};

        Human.Board.grid = new String[][]{
                // A   B   C   D   E   F   G   H   I   J
                {"C", "B", "B", "S", "S", "S", "P", "P", "P", "P"}, //Row 0
                {"C", "B", "B", "S", "S", "S", "P", "P", "P", "P"},
                {"C", "B", "B", "S", "S", "S", " ", " ", " ", " "},
                {"C", "B", "B", " ", " ", " ", " ", " ", " ", " "},
                {"C", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {"C", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        */


        //Gameloop:
        while(true) {
            Move.shooting(Human, Computer); // Human shoots
            ScoreboardChecker.checkStatus(Human, Computer); // did Human win?
            Move.shooting(Computer, Human); // Computer shoots
            // Printing game state
            GameBoard.printGameBoard(Human);
            ShootBoard.printShootBoard(Human);
            // check and print score
            ScoreboardChecker.checkStatus(Human, Computer);
            ScoreboardChecker.printScoreboard();
        }


        // MORE DEBUG

        // TEST SHOOT
        //System.out.println(Move.isFree(Computer.Board, arr1)); works, DEBUG
        //Move.shoot(Human, Computer, arr1); works, DEBBUG
        //Move.makeShot(Human, Computer); works, DEBUG
        /*
        Move.shoot(Human, Computer, arr2);
        Move.shoot(Human, Computer, arr3);
        Move.shoot(Human, Computer, arr4);
         */

        // TEST SHOOT (Random generated coordinates)
        //String st1 = Arrays.toString(Utils.ComputerRand(1)).substring(1,3); works, DEBUG
        //System.out.println(st1); works, DEBUG
        //Integer[] Gamescoord = Utils.cUInputToGameCord((ComputerRand[0]+" "+ComputerRand[1]));
        //System.out.println(Gamescoord);
        //String[] Output= Utils.GameCordtowriteArray(Gamescoord);
        //System.out.println(Arrays.toString(Output));

        // Test to access all the attributes of the shipList // works
        /*
        for(Ship ship : Computer.shipList) {
         System.out.println(ship.getName() + " has length " + ship.length);
        }
        */
    }
}
