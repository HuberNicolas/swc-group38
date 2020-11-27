import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Before
    void setUp() {
    }

    /**
     * @param: date = "12.03.2020"
     * In this Test we create a which rides the MicroCar
     */
    @Test
    public void MicroCarTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer Sandro = new Customer("12.03.2020", new MicroCar());
        Sandro.ride();

        String expectedOutput  = "Micro Car; 1 small bag; normal speed; 12 CHF/h\n";

        assertEquals(expectedOutput, outContent.toString());
    }
    /**
     * @param: date = "12.04,2020"
     * In this Test we create a which rides the Bus
     */
    @Test
    public void BusTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer Marco = new Customer("12.04,2020", new Bus());
        Marco.ride();

        String expectedOutput  = "Bus; unlimited bags; slow speed; 5 CHF\n";

        assertEquals(expectedOutput, outContent.toString());
    }
    /**
     * @param: date = "12.05,2020"
     * In this Test we create a which rides the SuperCar
     */
    @Test
    public void SupercarTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer Felix = new Customer("12.05,2020", new Supercar());
        Felix.ride();

        String expectedOutput  = "Supercar; 1 small and 1 large bag; fast speed; 30 CHF/h\n";

        assertEquals(expectedOutput, outContent.toString());
    }
    /**
     * @param: date = "12.06,2020"
     * In this Test we create a which rides the FamiliyCar
     */
    @Test
    public void FamilyCarTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer George = new Customer("12.06,2020", new FamilyCar());
        George.ride();

        String expectedOutput  = "Family Car; 2 small and 2 large bags; normal speed; 15 CHF/h\n";

        assertEquals(expectedOutput, outContent.toString());
    }
    /**
     * @param: date = "121212" but is not relevant, vehicle = null (which is not valid)
     * In this Test we check, if the system raises a NullPointerException if the vehicle=null
     */
    @Test
    public void NullPointerException(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer Steve = new Customer("121212", null);
        try {
            Steve.ride();
        }
        catch(NullPointerException e) {
            //expected exception
        }
        String expectedOutput  = "Customer can't ride, there is no vehicle chosen";

        assertEquals(expectedOutput, outContent.toString());
    }

    @After
    void tearDown() {
    }
}