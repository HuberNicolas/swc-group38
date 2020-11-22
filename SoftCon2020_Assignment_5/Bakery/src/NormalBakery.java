import java.util.ArrayList;

public class NormalBakery extends SuperBakery {

    //Constructor of NormalBakery
    public NormalBakery(String BakeryName, String StreetName, Integer StreetNumber, Integer PostalCode, String City){
        this.BakeryName = BakeryName;
        this.StreetName = StreetName;
        this.StreetNumber = StreetNumber;
        this.PostalCode = PostalCode;
        this.City = City;

        //Check if BakerName is already used:
        if(AllBakeries.contains(BakeryName)){
            throw new IllegalArgumentException("The bakeryname is already used");
        }
        else {
            AllBakeries.add(BakeryName);
        }
    }
}
