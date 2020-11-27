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

    @Test
    public void MicroCarTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer Sandro = new Customer("12.03.2020", new MicroCar());
        Sandro.ride();

        String expectedOutput  = "Micro Car; 1 small bag; normal speed; 12 CHF/h\n";

        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void BusTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer Marco = new Customer("12.04,2020", new Bus());
        Marco.ride();

        String expectedOutput  = "Bus; unlimited bags; slow speed; 5 CHF\n";

        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void SupercarTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer Felix = new Customer("12.05,2020", new Supercar());
        Felix.ride();

        String expectedOutput  = "Supercar; 1 small and 1 large bag; fast speed; 30 CHF/h\n";

        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void FamilyCarTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer George = new Customer("12.06,2020", new FamilyCar());
        George.ride();

        String expectedOutput  = "Family Car; 2 small and 2 large bags; normal speed; 15 CHF/h\n";

        assertEquals(expectedOutput, outContent.toString());
    }
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