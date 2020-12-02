import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
public class Utils {
    static ArrayList<Integer> IDList = new ArrayList<Integer>();

    /**
     *
     * @return: ID which is 8 digits and unique
     */
    static int generateID(){
        // generates ID
        int ID = ThreadLocalRandom.current().nextInt(10000000, 100000000);
        while (IDList.contains(ID)){
            ID = ThreadLocalRandom.current().nextInt(10000000, 100000000);
        }
        IDList.add(ID);
        return ID;
    }
}
