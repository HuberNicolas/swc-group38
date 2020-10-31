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
        // Init gameBoard Board
        GameBoard humanGameBoard = new GameBoard();
        GameBoard computerGameBoard = new GameBoard();
        GameBoard humanShootBoard = new GameBoard();
        GameBoard computerShootBoard = new GameBoard();
        Human Human = new Human(humanGameBoard, new GameBoard());
        Computer Computer = new Computer(computerGameBoard, new GameBoard());
        //Move.placingShips(Human);
        //GameBoard.printBoard(Human.Board);
        Move.placingShips(Computer);
        GameBoard.printBoard(Computer.Board);
        Integer arr1[] = {1,2};
        Integer arr2[] = {1,3};
        Integer arr3[] = {1,4};
        Integer arr4[] = {1,5};

        Move.shooting(Human, Computer);
        //System.out.println(Move.isFree(Computer.Board, arr1)); works, DEBUG
        //Move.shoot(Human, Computer, arr1); works, DEBBUG
        //Move.makeShot(Human, Computer); works, DEBUG
        /*
        Move.shoot(Human, Computer, arr2);
        Move.shoot(Human, Computer, arr3);
        Move.shoot(Human, Computer, arr4);
         */






        System.out.println(Arrays.toString(Utils.ShootCoordtoArray(arr1)));
        System.out.println(Arrays.toString(Utils.ShootCoordtoArray(arr2)));
        System.out.println(Arrays.toString(Utils.ShootCoordtoArray(arr3)));
        System.out.println(Arrays.toString(Utils.ShootCoordtoArray(arr4)));


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

        // INSERT OBSERVER HERE TO CHECK ALL LIFEPOINTS
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
