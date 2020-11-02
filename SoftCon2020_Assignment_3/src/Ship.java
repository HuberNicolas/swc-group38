/**
 * CLASS Ship
 * extends the abstract class ShipI and
 * Models an Ship entity of the Battleship-Game
 */
public class Ship extends ShipI{
    public String name; // eg. "Carrier"
    public int length; // eg. "6"
    public String shortName; // eg. "C"
    public int identity;
    public String[] coordArray; // eg. [A1, A2, A4, A4, A5, A6]
    public String owner; // eg. Player
    public int lifepoints; // eg. 6
    public boolean isAlive; // true

    // Constructor
    Ship(String n, int l, String sN, int id, String [] coord,String own, int HP, boolean alive) {
        name = n;
        length = l;
        shortName = sN;
        identity=id;
        coordArray = coord;
        owner= own;
        lifepoints= l;
        isAlive = true;

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

