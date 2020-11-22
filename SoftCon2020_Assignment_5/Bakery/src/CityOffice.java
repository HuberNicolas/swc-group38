import java.util.ArrayList;


public class CityOffice {
    static ArrayList<String> CityOffice = new ArrayList<String>();
    String CityOfficeName;
    ArrayList<String> ListOfBakeries = new ArrayList<String>();
    String CityOfficeNameComplete; //eg "city office of Roma"
    String FirstBakery;
    //constructor
    public CityOffice(String CityOfficeName){
        String prefix ="city office of ";
        this.CityOfficeName = CityOfficeName;
        CentralOffice.AllCityOffices.add(CityOfficeName);
        this.CityOfficeNameComplete = (prefix+CityOfficeName);
        CentralOffice.CityOfficesListToSearch.add(this);
    }

    public void printAllBakeriesNames(){
        System.out.println(ListOfBakeries);
    }
}
