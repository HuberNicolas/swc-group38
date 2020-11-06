import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
generate ID and generate IBAN create int, which are only made once
*/
public class Utils {
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

    /**
     *
     * @param c
     * Simple printer
     */
    static void printCustomer(Customer c) {
        System.out.println("Surname: "+c.Surname);
        System.out.println("Name: "+c.Name);
        System.out.println("ID : "+c.ID);
        System.out.println("Limit : "+ c.getLimit(c));
        System.out.println("Age : "+c.getAge(c));
        System.out.println("Money : "+ c.getMoney(c));
        System.out.println("IBAN : "+c.getIBAN(c));

    }
}
