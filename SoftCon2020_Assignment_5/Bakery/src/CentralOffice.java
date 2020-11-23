import java.util.ArrayList;

/**
 * The central office can only be initianted once. It can print all offices and their bakeries
 * Singleton design pattern is used here
 */

public class CentralOffice {
    static ArrayList<String> AllCityOffices = new ArrayList<String>();
    static ArrayList<CityOffice> CityOfficesListToSearch = new ArrayList<CityOffice>();
    private static CentralOffice uniqueInstance;

    public static CentralOffice getInstance(){
        if (uniqueInstance==null){
            uniqueInstance = new CentralOffice();
        }
        return uniqueInstance;
    }


    /**
     * @output: prints the name of each city office and names of all bakeries associated to the specific city office
     */
    public void printAllOffices(){

        for (int i = 0; i < CentralOffice.AllCityOffices.size(); i++){
            System.out.print(CentralOffice.CityOfficesListToSearch.get(i).CityOfficeNameComplete);
            System.out.print(", ");
            for (int j = 0; j < CentralOffice.CityOfficesListToSearch.get(i).ListOfBakeries.size(); j++){
                System.out.print(CentralOffice.CityOfficesListToSearch.get(i).ListOfBakeries.get(j));
                System.out.print(", ");
            }
            //System.out.print(CentralOffice.CityOfficesListToSearch.get(i).ListOfBakeries);
        }

    }

}
