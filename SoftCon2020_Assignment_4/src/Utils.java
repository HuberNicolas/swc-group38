import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
generate ID and generate IBAN create int, which are only made once
*/
public class Utils{
    static ArrayList<Integer> IDList = new ArrayList<Integer>();
    static ArrayList<Integer> IBANList = new ArrayList<Integer>();

    // 3 numbers eg. 128
    static int generateID(){
         int ID = ThreadLocalRandom.current().nextInt(1, 999);
        while (IDList.contains(ID)){
                ID = ThreadLocalRandom.current().nextInt(1, 999);
        }
         IDList.add(ID);
         return ID;
    }

    // 6 numbers eg. 171839
    static int generateIBAN(){
        int IBAN = ThreadLocalRandom.current().nextInt(100000, 1000000);
        while (IBANList.contains(IBAN)){
            IBAN = ThreadLocalRandom.current().nextInt(100000, 1000000);
        }
        IBANList.add(IBAN);
        return IBAN;
    }

    // 7 numbers eg. 1718392
    static int generateSerialNumber(){
        int SerialNumber = ThreadLocalRandom.current().nextInt(1000000, 10000000);
        while (IBANList.contains(SerialNumber)){
            SerialNumber = ThreadLocalRandom.current().nextInt(1000000, 10000000);
        }
        IBANList.add(SerialNumber);
        return SerialNumber;
    }

    // 3 numbers eg. 172
    static int generateSecurityCode(){
        int SecurityCode = ThreadLocalRandom.current().nextInt(100, 1000);
        while (IBANList.contains(SecurityCode)){
            SecurityCode = ThreadLocalRandom.current().nextInt(100, 1000);
        }
        IBANList.add(SecurityCode);
        return SecurityCode;
    }

    static LocalDate generateExpDate() {
        Random ran = new Random();
        int minDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2025, 12, 31).toEpochDay();
        long randomDay = minDay + ran.nextInt(maxDay - minDay);
        LocalDate expDate = LocalDate.ofEpochDay(randomDay);
        return expDate;
    }

    /**
     *
     * @param c
     * Simple printer
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

    static void printCustomersCard(Customer c) {
        System.out.println("Owner of the card: " + c.Surname + " " + c.Name);
        System.out.println("Type of the card: " + c.getCard(c).getType(c.getCard(c)));
        System.out.println("Serial Number of the card: " + c.getCard(c).getSerialNumber(c.getCard(c)));
        System.out.println("Security Code of the card: " + c.getCard(c).getSecurityCode(c.getCard(c)));
        System.out.println("Experience date of the card: " + c.getCard(c).getExpDate(c.getCard(c)).format(DateTimeFormatter.ofPattern("dd-MM-yy")));
    }

    static void printEmployee(Employee e) {
        System.out.println("Name: "+e.Name);
        System.out.println("Surname: "+e.Surname);
        System.out.println("ID : "+e.ID);
    }

}
