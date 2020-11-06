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
        System.out.println("Hello Word");

        Customer Nicolas = new Customer("Nicolas","Huber",5000,23, 1000);
        ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object

        SectionChief sC = new SectionChief("Zürich");
        MainChief mC = new MainChief();
        System.out.println(Utils.generateID());
        System.out.println(Utils.generateID());
        System.out.println(Utils.generateIBAN());
        Utils.generateID();
        Utils.printCustomer(Nicolas);

    }
}