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

        System.out.println("Welcome to Battleship!!");
        GameBoard humanGameBoard = new GameBoard();
        GameBoard computerGameBoard = new GameBoard();
        Human Human = new Human(humanGameBoard, new ShootBoard());
        Computer Computer = new Computer(computerGameBoard, new ShootBoard());

        // Init gameBoard Board, Singleton

        Move.placingShips(Human);
        GameBoard.printBoard(Human.Board);
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
        Move.placingShips(Computer);
        GameBoard.printBoard(Computer.Board);

        //Integer[] Gamescoord = Utils.cUInputToGameCord((ComputerRand[0]+" "+ComputerRand[1]));
        //System.out.println(Gamescoord);
        //String[] Output= Utils.GameCordtowriteArray(Gamescoord);
        //System.out.println(Arrays.toString(Output));



        // Test to access all the attributes of the shipList // works
        /* for(Ship ship : Computer.shipList) {
         System.out.println(ship.getName() + " has length " + ship.length);
        }
       */





        // Computer is generating his gameboard



        // Gameloop player is shooting, Computer is shooting and repeat

        // Iterator

        //while(true) {
            // Player 1 is shooting (check is_shot?)
            // Check Conditions
            // Computer is shooting
            // Check Conditions
        //}
    }

}
