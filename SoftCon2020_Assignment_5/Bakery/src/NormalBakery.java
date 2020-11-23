import java.util.ArrayList;
import java.lang.reflect.*;

public class NormalBakery extends SuperBakery {

    //Constructor of NormalBakery
    public NormalBakery(String BakeryName, String StreetName, Integer StreetNumber, Integer PostalCode, String City){
        this.BakeryName = BakeryName;
        this.StreetName = StreetName;
        this.StreetNumber = StreetNumber;
        this.PostalCode = PostalCode;
        this.City = City;
        String prefix ="city office of ";
        //Check if BakerName is already used:
        if(AllBakeries.contains(BakeryName)){
            throw new IllegalArgumentException("The bakeryname is already used");
        }
        else {
            AllBakeries.add(BakeryName);
        }
        //Check if there is already a Cityoffice
        if(CentralOffice.AllCityOffices.contains(City)){
            //City already has an office, so add new bakery to city's list, search for object Cityoffice, whose name is the correct city
            //System.out.println("Theres already Cityoffice");
            CityOffice FoundCity;
            for (int i = 0; i < CentralOffice.CityOfficesListToSearch.size(); i++){
                //System.out.println(CentralOffice.CityOfficesListToSearch);
                //System.out.println(CentralOffice.CityOfficesListToSearch.get(i).CityOfficeName);
                if (CentralOffice.CityOfficesListToSearch.get(i).CityOfficeName==City){

                    FoundCity= CentralOffice.CityOfficesListToSearch.get(i);
                    Integer Index = CentralOffice.CityOfficesListToSearch.indexOf(FoundCity);
                    //System.out.println(Index);
                    CentralOffice.CityOfficesListToSearch.get(Index).ListOfBakeries.add(BakeryName);
                }
            }



        }
        else {
            //No cityOffice
            throw new IllegalArgumentException("There is no CityOffice in this particular City!");
        }
    }

    @Override
    public void sellItems(String Item, ArrayList Decorators) {

    }
}
