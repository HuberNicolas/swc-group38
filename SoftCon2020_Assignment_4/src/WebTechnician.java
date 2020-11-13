/**
 * CLASS WEBTECHNICIAN
 * class for all entities of type WEBTECHNICIAN
 * models an human entity of a Webtechnician
 */
public class WebTechnician extends Technician{

    // Constructor
    public WebTechnician(String name, String surname) {
        // use super constructor of Technician
        super(name,surname);
    }

    /**
     * description                      technicians fixes website after 30s
     *                                  after a successful reparation, prints status
     */
    void fixWebsite(){
        try {
            Thread.sleep(30000);
        } catch(InterruptedException e) {
            System.out.println("could not do reparations");
        }
        System.out.println("reparations complete");
    }
}
