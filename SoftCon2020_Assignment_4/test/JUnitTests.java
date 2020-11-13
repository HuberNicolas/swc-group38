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
    //create test customers
    Bank Bank = new Bank();
    Customer Nicolas = new Customer("Huber","Nicolas",2000,23, 3000);
    Customer Louis = new Customer("Huber","Louis",5000,21, 0);
    Customer Alfredo = new Customer("Ramponelli","Alfredo",5000,65, 5000);
    Customer Mirko = new Customer("Bjelic","Mirko",10000,45, 5000);
    Customer Edgar = new Customer("Meier","Edgar",2000,26, 5000);
    Customer Carlo = new Customer("Romano","Carlo",2000,18, 0);
    Customer Fabio = new Customer("Regulare","Fabio",2000,28, 0);
    Customer Antonio = new Customer("Oro","Antonio",5000,28, 0);
    Customer Ricardo = new Customer("Platinum","Ricardo",10000,28, 0);
    //create test employees:
    Employee Luciano = new Employee("Rossi","Luciano");
    SectionChief Roberto = new SectionChief("Carlos", "Roberto", "Napoli");
    MainChief Dante = new MainChief("Fiero", "Dane");
    //create test Technicians
    WebTechnician Alonso = new WebTechnician("Rossini", "Alonso");
    BackendTechnician Fernando = new BackendTechnician("Bianci", "Fernando");

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


    /**
     * @result Account will be persisted without any errors,
     *         and Account.getId() will no longer be <code>null</code>
     */
    @Test
    void depositNegAmountOfMoney(){
        try {
            Nicolas.deposit(Nicolas,-10);
        } catch (Exception e) {
            fail("Should thrown an exception if value is negative");
        }
    }

    @Test
    void sendNegAmountOfMoney(){
        try {
            Nicolas.bankTransfer(Nicolas,Louis, -10);
        } catch (Exception e) {
            fail("Should thrown an exception if value is negative.");
        }
    }

    @Test
    //deposit 1000 so now Louis should have 1000 in the account
    void depositcorrectMoney() {
       Louis.deposit(Louis,1000);
        {
            assertEquals(Louis.getMoney(Louis),1000);
        }
    }
    @Test
        //deposit -1000 so now an error should appear
    void depositnegativeMoney() {
        try {
            Louis.deposit(Louis,-1000);
        } catch (Exception e) {
            fail("You cannot deposit less than 0 CHF. No Money was deposited.");
        }
    }
//test withdrawing money
    @Test
    void withdrawToMuchMoney() {
        assertEquals(Nicolas.withdraw(Nicolas,4000),0);
    }

    @Test
    void withdrawCorrectMoney() {
        assertEquals(Nicolas.withdraw(Nicolas,1000),1000);
    }
//test banktransfer
        @Test
    void banktransferCorrectMoney() {
    Nicolas.bankTransfer(Nicolas,Carlo,1000);
    //now Carlo will have 1000 on his account
        {assertEquals(Carlo.getMoney(Carlo),1000);}
    }

    @Test
    void banktransferIncorrectMoney() {
        try {
            Nicolas.bankTransfer(Nicolas,Carlo,-1000);
        } catch (Exception e) {
            fail("You can not send a negative amount of money. No Money was transferred.");
        }
    }
    //test creditcard systems:
    //Fabio (regular customer has 0 money but should still pay up to 2000 with his card
    @Test
    void Regularcustomerpayswithcardcorrectlimit() {
    Fabio.payWithCard(Fabio,2000);
    }
    @Test
    void RegularcustomerpayswithcardtoMuchlimit() {
        try {
            Fabio.payWithCard(Fabio,2001);
        } catch (Exception e) {
            fail("Your current limit " + Fabio.getLimit(Fabio) + " is not big enough. This payment would overcharge your creditcard. No transaction was made.");
        }
    }
    //test creditcard systems golden:
    //Antonio (golden customer has 0 money but should still pay up to 5000 with his card
    @Test
    void Goldencustomerpayswithcardcorrectlimit() {
        Antonio.payWithCard(Antonio,5000);
    }
    @Test
    void GoldencustomerpayswithcardtoMuchlimit() {
        try {
            Antonio.payWithCard(Antonio,5001);
        } catch (Exception e) {
            fail("Your current limit " + Antonio.getLimit(Antonio) + " is not big enough. This payment would overcharge your creditcard. No transaction was made.");
        }
    }
    //test creditcard systems platinum:
    //Ricardo (platinum customer has 0 money but should still pay up to 10000 with his card
    @Test
    void Platinumcustomerpayswithcardcorrectlimit() {
        Ricardo.payWithCard(Ricardo,10000);
    }
    @Test
    void PlatinumcustomerpayswithcardtoMuchlimit() {
        try {
            Ricardo.payWithCard(Ricardo,10001);
        } catch (Exception e) {
            fail("Your current limit " + Ricardo.getLimit(Ricardo) + " is not big enough. This payment would overcharge your creditcard. No transaction was made.");
        }
    }


    //test Bank employees
    //no second SectionChief for same City can be added
    @Test
    void noSecondSectionChief() {
        Employee Sandro = null;
        try {
            Sandro = new SectionChief("sandro", "nussbaumer", "Zürich");
        } catch (Exception e) {
            fail("There is already a SectionChief working in " + ((SectionChief) Sandro).getCity());
        }
    }
    //regular employee Luciano cannot upgrade Fabio (not his customer)
    @Test

    void Regularemployee_notCustomerupgradeRegToGold() {
        try {
            int custID = Fabio.ID;
            Luciano.upgradeRegToGold(custID, Luciano.CustomerList);
        }catch (Exception e) {
            fail("This ID does not exist.");
        }
    }
    @Test
    void Regularemployee_isCustomerupgradeRegToGold() {
        try {
            int custID = Fabio.ID;
            Luciano.addCustomer(Fabio);
            Luciano.upgradeRegToGold(custID, Luciano.CustomerList);
        }catch (Exception e) {
            fail("This ID does not exist.");
        }
    }
    //but he cannot upgrade Antoio which is a gold customer
    @Test
    void Regularemployee_isCustomer_upgradeRegToGold_but_CustomerisalreadyGold() {
        try {
            int custID = Antonio.ID;
            Luciano.addCustomer(Antonio);
            Luciano.upgradeRegToGold(custID, Luciano.CustomerList);
        }catch (Exception e) {
            fail("The customers credit card is already a gold card.");
        }
    }

    // section Chief Roberto
    @Test
    //differently from a regular employee, a section chief can upgrade a customer level
    //from Golden to Platinum
    void SectionChiefupgrade_fromRegtoGoldtoPlat() {
        int custID = Fabio.ID;
        Roberto.addCustomer(Fabio);
        Roberto.upgradeRegToGold(custID, Roberto.CustomerList);
        Roberto.upgradeGoldToPlat(custID, Roberto.CustomerList);
    }
    //Test downgrade from gold to Reg
    @Test
    void SectionChiefdowngradeGoldtoReg() {
        int custID = Louis.ID;
        Roberto.addCustomer(Louis);
        Roberto.downgradeGoldToReg(custID, Roberto.CustomerList);
    }
    //but cannot downgrade vom Platinum to Gold

    //Test Main Chief: Can everything a Section Chief can but can also downgrade vom Platinum go Gold
    @Test
    void MainChiefdowngradePlattoGold() {
        int custID = Ricardo.ID;
        Dante.addCustomer(Ricardo);
        Dante.downgradePlatToGold(custID, Dante.CustomerList);
    }

    @Test
    void MainChief_notCustomerupgradeRegToGold() {
        try {
            int custID = Fabio.ID;
            Dante.upgradeRegToGold(custID, Dante.CustomerList);
        }catch (Exception e) {
            fail("This ID does not exist.");
        }
    }
    @Test
    void MainChief_isCustomerupgradeRegToGold() {
        try {
            int custID = Fabio.ID;
            Dante.addCustomer(Fabio);
            Dante.upgradeRegToGold(custID, Dante.CustomerList);
        }catch (Exception e) {
            fail("This ID does not exist.");
        }
    }

    @Test
    void MainChief_isCustomer_upgradeRegToGold_but_CustomerisalreadyGold() {
        try {
            int custID = Antonio.ID;
            Dante.addCustomer(Antonio);
            Dante.upgradeRegToGold(custID, Dante.CustomerList);
        }catch (Exception e) {
            fail("The customers credit card is already a gold card.");
        }
    }


    @Test
    void MainChiefupgrade_fromRegtoGoldtoPlat() {
        int custID = Fabio.ID;
        Dante.addCustomer(Fabio);
        Dante.upgradeRegToGold(custID, Dante.CustomerList);
        Dante.upgradeGoldToPlat(custID, Dante.CustomerList);
    }
    //Test downgrade from gold to Reg
    @Test
    void MainChiefdowngradeGoldtoReg() {
        int custID = Louis.ID;
        Dante.addCustomer(Louis);
        Dante.downgradeGoldToReg(custID, Dante.CustomerList);
    }


    //Test Technicians
    @Test
    void Webtechnician() {
        Alonso.fixWebsite();
    }
    @Test
    void BackendTecnician_correctID() {
        Fernando.fixBackend(Fernando,Fernando.ID);
    }
    @Test
    void BackendTecnician_wrongID() {
        try {
            Fernando.fixBackend(Fernando,Alonso.ID);
        }catch (Exception e) {
            fail("This ID does not match to the backend technicians ID.\n");
        }
    }

    //general Tests regarding Customers
    @Test
    void customerCreationInvalidLimit() {
        try {
            Customer Pietro = new Customer("Lombardi","Pietro",2001,23, 3000);
        }catch (Exception e) {
            fail("Invalid limit entered! Set to default limit of 2000 CHF.");
        }

    }
    @Test
    //has to be fixed
    void customerCreationInvalidAge() {
        try {
            Customer Pietro = new Customer("Lombardi","Pietro",2000,-1, 3000);
        }catch (Exception e) {
            fail("Invalid limit entered! Set to default limit of 2000 CHF.");
        }

    }
    @Test
        //has to be fixed

    void customerCreationInvalidMoney() {
        try {
            Customer Pietro = new Customer("Lombardi","Pietro",2000,28, -1);
        }catch (Exception e) {
            fail("Invalid limit entered! Set to default limit of 2000 CHF.");
        }

    }
// dont know what to do???
    @Test
    void customerValid() {

    }

    @Test
    void jUnitTest() {
        // test for Louis
    }

    //get rid of customers
    @After
    public void tearDown() {
    }


}