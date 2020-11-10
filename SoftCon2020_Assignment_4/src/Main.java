/**
 * Description:             Banksimulation
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
        // INIT
        Customer Nicolas = new Customer("Huber","Nicolas",2000,23, 3000);
        Customer Louis = new Customer("Huber","Louis",5000,21, 5000);
        SectionChief sC = new SectionChief("Fish", "John", "Zürich");
        MainChief mC = new MainChief("McAllister", "Edward");
        Employee e = new Employee("Thomson", "Allie");
        // global Customer List
        ArrayList<Customer> globalCustomerList = new ArrayList<>();
        globalCustomerList.add(Nicolas);
        globalCustomerList.add(Louis);


        // CUSTOMERS
        System.out.println("######### CUSTOMERS #########");
        //System.out.println(Utils.generateID());
        //System.out.println(Utils.generateID());
        //System.out.println(Utils.generateIBAN());
        Utils.printCustomer(Nicolas);
        Nicolas.withdraw(Nicolas,4000);
        Nicolas.withdraw(Nicolas,250);
        Utils.printCustomer(Nicolas);
        Nicolas.deposit(Nicolas, 1000);
        Utils.printCustomer(Nicolas);
        Utils.printCustomer(Louis);
        Nicolas.bankTransfer(Nicolas,Louis,22);
        Utils.printCustomer(Nicolas);
        Utils.printCustomer(Louis);
        Utils.printCustomersCard(Nicolas);
        Nicolas.payWithCard(Nicolas,1000);

        // EMPLOYEES
        System.out.println("######### EMPLOYEES #########");
        sC.addCustomer(Nicolas);
        sC.addCustomer(Louis);
        sC.printCustomerList(sC);
        mC.addCustomer(Nicolas);
        mC.addCustomer(Louis);
        mC.printCustomerList(mC);
        e.addCustomer(Nicolas);
        e.addCustomer(Louis);
        e.printCustomerList(e);

        System.out.println("######### EMPLOYEES2 #########");
        sC.upgradeRegToGold(Nicolas.ID);
        Utils.printCustomer(Nicolas);
    }

}