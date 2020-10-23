/**
 * CLASS Ship
 * extends the abstract class ShipI and
 * Models an Ship entity of the Battleship-Game
 */
public class Ship extends ShipI{
    public String name; // eg. "Carrier"
    public int length; // eg. "6"
    public String shortName; // eg. "C"

    // Constructor
    Ship(String n, int l, String sN, int id, String [] coord,String owner, int LP, boolean alive) {
        name = n;
        length = l;
        shortName = sN;
        id=id;
        coord = coord;
        owner= owner;
        LP= l;
        alive = true;

    }

    // Getter
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String getShortName() {
        return shortName;
    }
}

