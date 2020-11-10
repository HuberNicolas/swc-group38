import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class JUnitTests {

    Customer Nicolas = new Customer("Huber","Nicolas",2000,23, 3000);
    Customer Louis = new Customer("Huber","Louis",5000,21, 5000);
    Customer Alfredo = new Customer("Ramponelli","Alfredo",5000,65, 5000);
    Customer Mirko = new Customer("Bjelic","Mirko",10000,45, 5000);
    Customer Edgar = new Customer("Meier","Edgar",2000,26, 5000);
    ArrayList<Customer> globalCustomerList = new ArrayList<>();




    @Before
    void setUp() {
        globalCustomerList.add(Nicolas);
        globalCustomerList.add(Louis);
        globalCustomerList.add(Alfredo);
        globalCustomerList.add(Mirko);
        globalCustomerList.add(Edgar);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void depositLessThan0(){
        try {
            Nicolas.deposit(Nicolas,-10);
            fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {
            assertEquals(e,IllegalArgumentException.class);
            
        }

    }



}