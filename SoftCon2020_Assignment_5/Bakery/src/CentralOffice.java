import java.util.ArrayList;
//Singleton design pattern is used here

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
}
