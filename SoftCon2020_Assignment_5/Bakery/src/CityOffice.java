import java.util.ArrayList;

/**
 * their is only one cityoffice per city. each city of has a list of all associated bakeries
 * can print this bakeries with printAllBakeriesNames()
 */
public class CityOffice {
    static ArrayList<String> CityOffice = new ArrayList<String>();
    String CityOfficeName;
    ArrayList<String> ListOfBakeries = new ArrayList<String>();
    String CityOfficeNameComplete; //eg "city office of Roma"
    String FirstBakery;

    //Constructor
    public CityOffice(String CityOfficeName){
        String prefix ="city office of ";
        this.CityOfficeName = CityOfficeName;
        CentralOffice.AllCityOffices.add(CityOfficeName);
        this.CityOfficeNameComplete = (prefix+CityOfficeName);
        CentralOffice.CityOfficesListToSearch.add(this);
    }

    /**
     * @prints all bakeries associated
     */
    public void printAllBakeriesNames(){

        for (int i = 0; i < ListOfBakeries.size(); i++){
            System.out.print(ListOfBakeries.get(i));
            System.out.print(", ");
        }
    }
}
