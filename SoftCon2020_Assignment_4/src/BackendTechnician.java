public class BackendTechnician extends Technician {

    public BackendTechnician(String name, String surname) {
        super(name, surname);
    }

    void fixBackend(BackendTechnician b, int ID) {
        try {
            if (b.ID != ID)throw new IllegalArgumentException("This ID does not match to the backend technicians ID.");
            else {
                System.out.println("fixed!");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
