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
    //The central office has a method "printAllOffices" that prints the name of each city office and
    //the names of all bakeries associated to the specific city office in the following way:
    //[name of city office 1], [name of bakery 1 belonging to city office 1], [name of bakery 2
    //belonging to city office 1], …, [name of city office 2], [name of bakery 1 belonging to city
    //office 2],
    public void printAllOffices(){

        for (int i = 0; i < CentralOffice.AllCityOffices.size(); i++){
            System.out.print(CentralOffice.CityOfficesListToSearch.get(i).CityOfficeNameComplete);
            System.out.print(", ");
            System.out.print(CentralOffice.CityOfficesListToSearch.get(i).ListOfBakeries);
        }

    }

}
