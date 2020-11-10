import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {
    Customer Nicolas = new Customer("Huber","Nicolas",5000,23, 3000);
    
    
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
        
        assertEquals(Nicolas.Surname, "Nicolas");
    }


    @Test
    void bankTransfer() {
    }

    @Test
    void payWithCard() {
    }
}