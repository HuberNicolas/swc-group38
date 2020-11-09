/**
 * Description:             A 2dim Version of the BATTLESHIP GAME
 * @Authors:                Robin Wassink, Louis Huber and Nicolas Huber
 *
 */

import java.time.LocalDate;
import java.net.StandardSocketOptions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;

public class Main {

    public static void main(String [] args) {
        System.out.println("Hello Word");

        Customer Nicolas = new Customer("Nicolas","Huber",5000,23, 3000);
        Customer Louis = new Customer("Louis","Huber",5000,21, 5000);
        ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object

        SectionChief sC = new SectionChief("Zürich");
        MainChief mC = new MainChief();
        System.out.println(Utils.generateID());
        System.out.println(Utils.generateID());
        System.out.println(Utils.generateIBAN());
        Utils.generateID();
        Utils.printCustomer(Nicolas);
        System.out.println(Nicolas.withdraw(Nicolas,4000));
        Utils.printCustomer(Nicolas);
        Nicolas.deposit(Nicolas, 1000);
        Utils.printCustomer(Nicolas);
        Utils.printCustomer(Louis);
        Nicolas.bankTransfer(Nicolas,Louis,22);
        Utils.printCustomer(Nicolas);
        Utils.printCustomer(Louis);
        Utils.printCustomersCard(Nicolas);
    }
}