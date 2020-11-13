import java.time.LocalDate;
import java.util.ArrayList;

/**
 * CLASS CREDICARD
 * class for an CreditCard entity
 * models a credit card of a customer
 */
public class CreditCard {
    private int SerialNumber;   // eg. 4741668
    private int SecurityCode;   // eg. 787
    private LocalDate ExpDate;  // eg. 14-07-25
    private String Type;        // eg. "regular"
    //private Customer Owner; prolly is not needed
    //private int Limit;

    // Constructor
    public CreditCard(int limit){
        ArrayList<Integer> validLimit = new ArrayList<Integer>();
        validLimit.add(2000);
        validLimit.add(5000);
        validLimit.add(10000);
        // check limit
        try {
            if (!validLimit.contains(limit)) throw new IllegalArgumentException("The entered limit is not valid.");
            else {
                switch (limit) {
                    case 2000:
                        this.Type = "regular";
                        break;
                    case 5000:
                        this.Type = "gold";
                        break;
                    case 10000:
                        this.Type = "platinum";
                        break;
                }
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.SerialNumber = Utils.generateSerialNumber();   // eg. 4741668
        this.SecurityCode = Utils.generateSecurityCode();   // eg. 824
        this.ExpDate = Utils.generateExpDate();             // eg. 14-06-25
    }

    // Getter and Setter

    // Getter
    static String getType(CreditCard c) { return c.Type; }

    // Getter
    static int getSerialNumber(CreditCard c) { return c.SerialNumber; }

    // Getter
    static int getSecurityCode(CreditCard c) { return c.SecurityCode; }

    // Getter
    static LocalDate getExpDate(CreditCard c) { return c.ExpDate; }
}



