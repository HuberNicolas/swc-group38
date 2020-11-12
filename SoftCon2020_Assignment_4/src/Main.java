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
        Customer Alfredo = new Customer("Ramponelli","Alfredo",5000,65, 5000);
        Customer Mirko = new Customer("Bjelic","Mirko",10000,45, 5000);
        Customer Edgar = new Customer("Meier","Edgar",2000,26, 5000);
        SectionChief sC = new SectionChief("Fish", "John", "Zürich");
        MainChief mC = new MainChief("McAllister", "Edward");
        Employee e = new Employee("Thomson", "Allie");
        WebTechnician w = new WebTechnician("Jet", "Lee");
        BackendTechnician b = new BackendTechnician("Moser", "Peter");
        // global Customer List
        ArrayList<Customer> globalCustomerList = new ArrayList<>();
        globalCustomerList.add(Nicolas);
        globalCustomerList.add(Louis);
        globalCustomerList.add(Alfredo);
        globalCustomerList.add(Mirko);
        globalCustomerList.add(Edgar);




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
        Nicolas.ID = 123;
        sC.upgradeRegToGold(123,globalCustomerList);
        Utils.printCustomer(Nicolas);
        sC.downgradeGoldToReg(123,globalCustomerList);
        Utils.printCustomer(Nicolas);
        sC.upgradeGoldToPlat(123,globalCustomerList);
        Utils.printCustomer(Nicolas);
        sC.upgradeRegToGold(123,globalCustomerList);
        Utils.printCustomer(Nicolas);
        sC.upgradeGoldToPlat(123,globalCustomerList);
        Utils.printCustomer(Nicolas);
        mC.downgradeToState(123,globalCustomerList,"regular");
        Utils.printCustomer(Nicolas);
        mC.upgradeRegToGold(123,globalCustomerList);
        mC.upgradeGoldToPlat(123,globalCustomerList);
        Utils.printCustomer(Nicolas);
        mC.downgradeToState(123,globalCustomerList,"goldd");
        mC.downgradeToState(123,globalCustomerList,"gold");

        // TECHNICIAN
        System.out.println("######### TECHNICIAN #########");
        //w.fixWebsite();
        b.ID = 145;
        b.fixBackend(b,146);
        b.fixBackend(b,145);


        Customer Francesco = new Customer("Balonetto","Francesco",4999,56, 6969);
        System.out.println(Francesco.getLimit(Francesco));
        Francesco.ID = 134;
        globalCustomerList.add(Francesco); // can u upgrade any or just the one in your list?
        mC.upgradeGoldToPlat(134,globalCustomerList);
        System.out.println(Francesco.getLimit(Francesco));
        mC.upgradeRegToGold(134,globalCustomerList);
        System.out.println(Francesco.getLimit(Francesco));
        mC.upgradeRegToGold(134,globalCustomerList);
        System.out.println(Francesco.getLimit(Francesco));

    }
}