import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getCard() {
    }

    @Test
    void getLimit() {
    }

    @Test
    void getAge() {
    }

    @Test
    void getIBAN() {
    }

    @Test
    void getMoney() {
    }

    @Test
    void setMoney() {
    }

    @Test
    void deposit() {
    }

    @Test
    void withdraw() {
        Customer Nicolas = new Customer("Nicolas","Huber",5000,23, 3000);
        //assertEquals(2, myClass.add(x,y));
        //Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> foo.doStuff());
        //assertEquals("expected messages", exception.getMessage());
        assertEquals(Nicolas.Surname, "Huber");
    }


    @Test
    void bankTransfer() {
    }

    @Test
    void payWithCard() {
    }
}