import java.util.ArrayList;

/**
 * abstract class which defines how a bakery shoudld be
 */
public abstract class SuperBakery {

    String BakeryName;  //eg. Crunchy Bakery , has to be unique
    String StreetName; //eg. first street
    Integer StreetNumber; //eg. 11
    Integer PostalCode; //eg. 90000
    String City;    //eg. Napoli

    //List, which contains all Bakeries, to check if the name is unique
    static ArrayList<String> AllBakeries = new ArrayList<String>();

    /**
     * @return
     * prints out the name of the bakery, works with every type of bakery
     */
    public void printName(){
        System.out.println(BakeryName);
    }

    /**
     *
     * @param Item: The Item you want to buy eg. Cake
     * @param Decorators: The list of Decoratros you want eg. Cream
     * @prints the price of the item
     */
    public abstract void sellItems(String Item, ArrayList Decorators);

}
