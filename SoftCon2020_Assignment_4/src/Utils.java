import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

/**
 * CLASS UTILS
 * provides generators and printers
 */
public class Utils{
    static ArrayList<Integer> IDList = new ArrayList<Integer>();
    static ArrayList<Integer> IBANList = new ArrayList<Integer>();

    // GENERATORS
    /**
     * @return                          a unique 3 digit integer number
     * description                      generates a random id for
     *                                  a human entity, for instance
     *                                  customer, employee and technician
     */
    static int generateID(){
        // 3 numbers eg. 128
         int ID = ThreadLocalRandom.current().nextInt(1, 999);
        while (IDList.contains(ID)){
                ID = ThreadLocalRandom.current().nextInt(1, 999);
        }
         IDList.add(ID);
         return ID;
    }

    /**
     * @return                          a unique 6 digit integer number
     * description                      generates a random unique IBAN for
     *                                  a credit card entity
     */
    static int generateIBAN(){
        // 6 numbers eg. 171839
        int IBAN = ThreadLocalRandom.current().nextInt(100000, 1000000);
        while (IBANList.contains(IBAN)){
            IBAN = ThreadLocalRandom.current().nextInt(100000, 1000000);
        }
        IBANList.add(IBAN);
        return IBAN;
    }

    /**
     * @return                          a unique 7 digit integer number
     * description                      generates a random unique serial number for
     *                                  a credit card entity
     */
    static int generateSerialNumber(){
        // 7 numbers eg. 1718392
        int SerialNumber = ThreadLocalRandom.current().nextInt(1000000, 10000000);
        while (IBANList.contains(SerialNumber)){
            SerialNumber = ThreadLocalRandom.current().nextInt(1000000, 10000000);
        }
        IBANList.add(SerialNumber);
        return SerialNumber;
    }

    /**
     * @return                          a unique 3 digit integer number
     * description                      generates a random unique security code for
     *                                  a credit card entity
     */
    static int generateSecurityCode(){
        // 3 numbers eg. 172
        int SecurityCode = ThreadLocalRandom.current().nextInt(100, 1000);
        while (IBANList.contains(SecurityCode)){
            SecurityCode = ThreadLocalRandom.current().nextInt(100, 1000);
        }
        IBANList.add(SecurityCode);
        return SecurityCode;
    }

    /**
     * @return                          a unique local date
     * description                      generates a random unique expiry date for
     *                                  a credit card entity
     */
    static LocalDate generateExpDate() {
        // eg. 14-07-25
        Random ran = new Random();
        int minDay = (int) LocalDate.of(2022, 11, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2025, 12, 31).toEpochDay();
        long randomDay = minDay + ran.nextInt(maxDay - minDay);
        LocalDate expDate = LocalDate.ofEpochDay(randomDay);
        return expDate;
    }


    // PRINTERS
    /**
     * @param c                         customers, whose attributes should be printed out
     * description                      prints customers attributes
     */
    static void printCustomer(Customer c) {
        System.out.println("Name: "+c.Name);
        System.out.println("Surname: "+c.Surname);
        System.out.println("Age : "+c.getAge(c));
        System.out.println("IBAN : "+c.getIBAN(c));
        System.out.println("Money : "+ c.getMoney(c));
        System.out.println("ID : "+c.ID);
        System.out.println("Limit : "+ c.getLimit(c));
    }

    /**
     * @param c                         customers, whose credit card should be printed out
     * description                      prints customers credit card attributes
     */
    static void printCustomersCard(Customer c) {
        System.out.println("Owner of the card: " + c.Surname + " " + c.Name);
        System.out.println("Type of the card: " + c.getCard(c).getType(c.getCard(c)));
        System.out.println("Serial Number of the card: " + c.getCard(c).getSerialNumber(c.getCard(c)));
        System.out.println("Security Code of the card: " + c.getCard(c).getSecurityCode(c.getCard(c)));
        System.out.println("Experience date of the card: " + c.getCard(c).getExpDate(c.getCard(c)).format(DateTimeFormatter.ofPattern("dd-MM-yy")));
    }

    /**
     * @param e                         employee, whose attributes should be printed out
     * description                      prints employees attributes
     */
    static void printEmployee(Employee e) {
        System.out.println("Name: "+e.Name);
        System.out.println("Surname: "+e.Surname);
        System.out.println("ID : "+e.ID);
    }
}
