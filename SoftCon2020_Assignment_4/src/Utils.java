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

     static int generateID(){
         int ID = ThreadLocalRandom.current().nextInt(1, 999);
        while (IDList.contains(ID)){
                ID = ThreadLocalRandom.current().nextInt(1, 999);
        }
         IDList.add(ID);
         return ID;
    }
    static int generateIBAN(){
        int IBAN = ThreadLocalRandom.current().nextInt(1, 999);
        while (IBANList.contains(IBAN)){
            IBAN = ThreadLocalRandom.current().nextInt(1, 999);
        }
        IBANList.add(IBAN);
        return IBAN;
    }
}
