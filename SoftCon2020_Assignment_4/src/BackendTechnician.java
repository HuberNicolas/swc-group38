/**
 * CLASS BACKENDTECHNICIAN
 * class for all entities of type BACKENDTECHNICIAN
 * models an human entity of a Backentechnician
 */
public class BackendTechnician extends Technician {

    // Constructor
    public BackendTechnician(String name, String surname) {
        // use super constructor of Technician
        super(name, surname);
    }

    /**
     *
     * @param b                         backendtechnician that wants to fix
     * @param ID                        id of the corresponding backendtechnician b
     * description                      if id matches to the backendtechnicians
     *                                  underdo the fix and print validation message
     */
    void fixBackend(BackendTechnician b, int ID) {
        // check if id corresponds to the backendtechnicians id
        try {
            // id does not match
            if (b.ID != ID)throw new IllegalArgumentException("This ID does not match to the backend technicians ID.");
            else {
                // id does match
                System.out.println("fixed!");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
