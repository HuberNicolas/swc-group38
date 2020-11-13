import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

//create test

class JUnitTests {
    /**
     * We used this Customers, employees and Technicians to Test the cases
     */
    Bank Bank = new Bank();
    Customer Nicolas = new Customer("Huber", "Nicolas", 2000, 23, 3000);
    Customer Louis = new Customer("Huber", "Louis", 5000, 21, 0);
    Customer Alfredo = new Customer("Ramponelli", "Alfredo", 5000, 65, 5000);
    Customer Mirko = new Customer("Bjelic", "Mirko", 10000, 45, 5000);
    Customer Edgar = new Customer("Meier", "Edgar", 2000, 26, 5000);
    Customer Carlo = new Customer("Romano", "Carlo", 2000, 18, 0);
    Customer Fabio = new Customer("Regulare", "Fabio", 2000, 28, 0);
    Customer Antonio = new Customer("Oro", "Antonio", 5000, 28, 0);
    Customer Ricardo = new Customer("Platinum", "Ricardo", 10000, 28, 0);
    //create test employees:
    Employee Luciano = new Employee("Rossi", "Luciano");
    SectionChief Roberto = new SectionChief("Carlos", "Roberto", "Zürich");
    MainChief Dante = new MainChief("Fiero", "Dane");
    //create test Technicians
    WebTechnician Alonso = new WebTechnician("Rossini", "Alonso");
    BackendTechnician Fernando = new BackendTechnician("Bianci", "Fernando");

    /**
     * Now they are added in Before to the Bank
     */
    @Before
    void setUp() {
        Bank.add_Customer(Nicolas);
        Bank.add_Customer(Louis);
        Bank.add_Customer(Alfredo);
        Bank.add_Customer(Mirko);
        Bank.add_Customer(Edgar);
        Bank.add_Customer(Carlo);
        Bank.add_Customer(Fabio);
        Bank.add_Customer(Antonio);
        Bank.add_Customer(Ricardo);
        Bank.add_Employee(Luciano, Bank.getEmployees());
        Bank.add_Employee(Roberto, Bank.getEmployees());
        Bank.add_Employee(Dante, Bank.getEmployees());
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // test customers

    /**
     * @throws Exception, as you cannot deposit a negative amount of money
     */
    @Test
    void depositNegAmountOfMoney() {
        try {
            Nicolas.deposit(Nicolas, -10);
        } catch (Exception e) {
            fail("Should thrown an exception if value is negative");
        }
    }

    /**
     * @throws Exception, as you should not send negative money
     */
    @Test
    void sendNegAmountOfMoney() {
        Louis.setIBAN(Louis, 171839);
        try {
            Nicolas.bankTransfer(Nicolas, 171839, -10, Bank.getCustomers());
        } catch (Exception e) {
            fail("Should thrown an exception if value is negative.");
        }
    }

    /**
     * @result print "You successfully deposited 1000 CHF to your bank account."
     * now customer Louis should have 1000 in his account
     */
    @Test
    //deposit 1000 so now Louis should have 1000 in the account
    void depositCorrectMoney() {
        Louis.deposit(Louis, 1000);
        {
            assertEquals(Louis.getMoney(Louis), 1000);
        }
    }

    /**
     * @throw Exception "You cannot deposit less than 0 CHF. No Money was deposited."
     */
    @Test
    void depositNegativeMoney() {
        try {
            Louis.deposit(Louis, -1000);
        } catch (Exception e) {
            fail("You cannot deposit less than 0 CHF. No Money was deposited.");
        }
    }

    /**
     * @throw: Exception "There is not enough money on you bank account. No Money was withdrawn."
     */
    @Test
    void withdrawToMuchMoney() {
        assertEquals(Nicolas.withdraw(Nicolas, 4000), 0);
    }

    /**
     * @result: print "You successfully withdraw 1000 CHF from your bank account."
     * now customer Nicolas has correctly withdrawn the money
     */
    @Test
    void withdrawCorrectMoney() {
        assertEquals(Nicolas.withdraw(Nicolas, 1000), 1000);
    }


    //test banktransfer

    /**
     * @param: The sender, the receiving IBAN, the amount of money and the global list with all customers
     * @result: print "Successfully transferred 1000 CHF from ID.sender to ID.receiver"
     */
    @Test
    void banktransferCorrectMoney() {
        Bank.add_Customer(Carlo);
        Nicolas.deposit(Nicolas, 100000);
        Nicolas.bankTransfer(Nicolas, Carlo.getIBAN(Carlo), 1000, Bank.getCustomers());
        //now Carlo will have 1000 on his account
        {
            assertEquals(1000, Carlo.getMoney(Carlo));
        }
    }

    /**
     * @param: The sender, the receiving IBAN, the amount of money and the global list with all customers
     * @throws exception: print "You can not send a negative amount of money. No Money was transferred."
     */
    @Test
    void banktransferIncorrectMoney() {
        Bank.add_Customer(Carlo);
        try {
            Nicolas.bankTransfer(Nicolas, Carlo.getIBAN(Carlo), -1000, Bank.getCustomers());
        } catch (Exception e) {
            fail("You can not send a negative amount of money. No Money was transferred.");
        }
    }


    //test credit card systems
    //regular

    /**
     * @result: print "Successfully payed 2000 CHF by card"
     */
    @Test
    void RegularCustomerPaysWithCardCorrectLimit() {
        //Fabio (regular customer has 0 money but should still pay up to 2000 with his card
        Fabio.payWithCard(Fabio, 2000);
    }

    /**
     * @throws exception: print "Your current limit 2000 is not big enough. This payment would overcharge your credit card. No transaction was made."
     */
    @Test
    void RegularCustomerPaysWithCardToMuchlimit() {
        try {
            Fabio.payWithCard(Fabio, 2001);
        } catch (Exception e) {
            fail("Your current limit " + Fabio.getLimit(Fabio) + " is not big enough. This payment would overcharge your creditcard. No transaction was made.");
        }
    }

    //golden

    /**
     * @result: print "Successfully payed 5000 CHF by card"
     */
    @Test
    void goldenCustomerPaysWithCardCorrectLimit() {
        //Antonio (golden customer has 0 money but should still pay up to 5000 with his card
        Antonio.payWithCard(Antonio, 5000);
    }

    /**
     * @throws exception: print "Your current limit 5000 is not big enough. This payment would overcharge your credit card. No transaction was made."
     */
    @Test
    void goldenCustomerPaysWithCardToMuchLimit() {
        try {
            Antonio.payWithCard(Antonio, 5001);
        } catch (Exception e) {
            fail("Your current limit " + Antonio.getLimit(Antonio) + " is not big enough. This payment would overcharge your creditcard. No transaction was made.");
        }
    }

    //platinum

    /**
     * @result: print "Successfully payed 10000 CHF by card"
     */
    @Test
    void platinumCustomerPaysWithCardCorrectLimit() {
        //Ricardo (platinum customer has 0 money but should still pay up to 10000 with his card
        Ricardo.payWithCard(Ricardo, 10000);
    }

    /**
     * @throws exception: print "Your current limit 10000 is not big enough. This payment would overcharge your credit card. No transaction was made."
     */
    @Test
    void platinumCustomerPaysWithCardToMuchLimit() {
        try {
            Ricardo.payWithCard(Ricardo, 10001);
        } catch (Exception e) {
            fail("Your current limit " + Ricardo.getLimit(Ricardo) + " is not big enough. This payment would overcharge your creditcard. No transaction was made.");
        }
    }


    //test bank employees

    // regular employee

    /**
     * @throws exception: prints "There is already a SectionChief working in CITY"
     */
    @Test
    void noSecondSectionChief() {
        //no second SectionChief for same City can be added
        Employee Sandro = null;
        try {
            setUp();
            Sandro = new SectionChief("Nussbaumer", "Sandro", "Zürich");
            Bank.add_Employee(Sandro, Bank.getEmployees());
        } catch (Exception e) {
            fail("There is already a SectionChief working in " + ((SectionChief) Sandro).getCity());
        }
    }

    /**
     * @param: customer ID from wrong person
     * @throws exception: print "This ID does not exist."
     */
    @Test
    void regulareEployeenotCustomerupgradeRegToGoldIDNotFound() {
        try {
            int custID = Fabio.ID;
            Luciano.upgradeRegToGold(custID, Luciano.CustomerList);
        } catch (Exception e) {
            fail("This ID does not exist.");
        }
    }

    /**
     * @param: customer ID from correct person
     * @result: print "Customer Fabio Regulare has now a gold credit card with a new limit of 5000 CHF."
     */
    @Test
    void regularEmployeeIsCustomerupgradeRegToGold() {
        try {
            int custID = Fabio.ID;
            Luciano.addCustomer(Fabio);
            Luciano.upgradeRegToGold(custID, Luciano.CustomerList);
        } catch (Exception e) {
            fail("This ID does not exist.");
        }
        //but he cannot upgrade Antonio which is a gold customer
    }


    /**
     * @throws exception: print "The customers credit card is already a gold card."
     * @param: custID from gold person
     */
    @Test
    void regularEmployeeIsCustomerUpgradeRegToGoldButCustomerIsAlreadyGold() {
        try {
            int custID = Antonio.ID;
            Luciano.addCustomer(Antonio);
            Luciano.upgradeRegToGold(custID, Luciano.CustomerList);
        } catch (Exception e) {
            fail("The customers credit card is already a gold card.");
        }
    }

    // section chief

    /**
     * @param: customer ID from gold person
     * @result: print "Customer Fabio Regulare has now a platin credit card with a new limit of 10000 CHF."
     */
    @Test
    void sectionChiefUpgradeFromRegToGoldToPlat() {
        //differently from a regular employee, a section chief can upgrade a customer level
        //from Golden to Platinum
        int custID = Fabio.ID;
        Roberto.addCustomer(Fabio);
        Roberto.upgradeRegToGold(custID, Roberto.CustomerList);
        Roberto.upgradeGoldToPlat(custID, Roberto.CustomerList);
    }

    /**
     * @param: custID from gold person
     * @result: print "Customer Louis Huber has now a regular credit card with a new limit of 2000 CHF."
     */
    @Test
    void sectionChiefDowngradeGoldToReg() {
        int custID = Louis.ID;
        Roberto.addCustomer(Louis);
        Roberto.downgradeGoldToReg(custID, Roberto.CustomerList);
        //but cannot downgrade vom Platinum to Gold
    }


    //main Chief: Can do everything a Section Chief can and also downgrade vom platinum go gold

    /**
     * @param: custID from platiunum person
     * @result: print "Customer Ricardo Platinum has now a gold credit card with a new limit of 5000 CHF."
     */
    @Test
    void mainChiefDowngradePlatToGold() {
        int custID = Ricardo.ID;
        Dante.addCustomer(Ricardo);
        Dante.downgradePlatToGold(custID, Dante.CustomerList);
    }

    /**
     * @throws exception: print "This ID does not exist."
     * @param: custID from wrong person
     */
    @Test
    void MainChiefNotCustomerUpgradeRegToGold() {
        try {
            int custID = Fabio.ID;
            Dante.upgradeRegToGold(custID, Dante.CustomerList);
        } catch (Exception e) {
            fail("This ID does not exist.");
        }
    }

    /**
     * @param: custID from correct person
     * @result: print "Customer Fabio Regulare has now a gold credit card with a new limit of 5000 CHF."
     */
    @Test
    void mainChiefIsCustomerUpgradeRegToGold() {
        try {
            int custID = Fabio.ID;
            Dante.addCustomer(Fabio);
            Dante.upgradeRegToGold(custID, Dante.CustomerList);
        } catch (Exception e) {
            fail("This ID does not exist.");
        }
    }

    /**
     * @throws exception: print "The customers credit card is already a gold card."
     * @param: custID from gold person
     */
    @Test
    void mainChiefIsCustomerUpgradeRegToGoldButCustomerIsAlreadyGold() {
        try {
            int custID = Antonio.ID;
            Dante.addCustomer(Antonio);
            Dante.upgradeRegToGold(custID, Dante.CustomerList);
        } catch (Exception e) {
            fail("The customers credit card is already a gold card.");
        }
    }

    /**
     * @param: custID from correct person
     * @result: print "Customer Fabio Regulare has now a gold credit card with a new limit of 5000 CHF." and "Customer Fabio Regulare has now a platin credit card with a new limit of 10000 CHF."
     */
    @Test
    void mainChiefUpgradeFromRegToGoldToPlat() {
        int custID = Fabio.ID;
        Dante.addCustomer(Fabio);
        Dante.upgradeRegToGold(custID, Dante.CustomerList);
        Dante.upgradeGoldToPlat(custID, Dante.CustomerList);
    }


    /**
     * @param: custID from gold person
     * @result: print "Customer Louis Huber has now a regular credit card with a new limit of 2000 CHF."
     */
    @Test
    void mainChiefDowngradeGoldToReg() {
        //Test downgrade from gold to Reg
        int custID = Louis.ID;
        Dante.addCustomer(Louis);
        Dante.downgradeGoldToReg(custID, Dante.CustomerList);
    }


    //Test Technicians

    /**
     * @result: first sleep then print "reparations complete"
     */
    @Test
    void webtechnician() {
        Alonso.fixWebsite();
    }

    /**
     * @param: correct ID from BackendTechnician
     * @result: first sleep then print "reparations complete"
     */
    @Test
    void backendTecnicianCorrectID() {
        Fernando.fixBackend(Fernando, Fernando.ID);
    }

    /**
     * @throws exception: print "This ID does not match to the backend technicians ID."
     * @param: correct ID from BackendTechnician
     */
    @Test
    void backendTecnicianWrongID() {
        try {
            Fernando.fixBackend(Fernando, Alonso.ID);
        } catch (Exception e) {
            fail("This ID does not match to the backend technicians ID.\n");
        }
    }


    //general Tests regarding Customers

    /**
     * @param: name, surname, incorrect limit, age,money
     * @result: new customer, limit = 2000 (regular)
     * @throws: print "TInvalid limit entered! Set to default limit of 2000 CHF."
     */
    @Test
    void customerCreationInvalidLimit() {
        try {
            Customer Pietro = new Customer("Lombardi", "Pietro", 2001, 23, 3000);
        } catch (Exception e) {
            fail("Invalid limit entered! Set to default limit of 2000 CHF.");
        }
        /**
         * @param: name, surname,  limit, wrong age,money
         * @result: new customer, age = 18
         * @throws: print "An age <= 0 is not valid. Set age to default value of 18."
         */
    }

    @Test
    void customerCreationInvalidAge() {
        try {
            Customer Pietro = new Customer("Lombardi", "Pietro", 2000, -1, 3000);
        } catch (Exception e) {
            fail("Invalid limit entered! Set to default limit of 2000 CHF.");
        }

    }

    /**
     * @param: name, surname,  limit, age,wrong money
     * @result: new customer, money = 0
     * @throws: print "Your bank account must contain at least 0 CHF. Set default value of saving to 0."
     */
    @Test
    void customerCreationInvalidMoney() {
        try {
            Customer Pietro = new Customer("Lombardi", "Pietro", 2000, 28, -1);
        } catch (Exception e) {
            fail("Invalid limit entered! Set to default limit of 2000 CHF.");
        }

    }

    @After
    public void tearDown() {
    }
}
