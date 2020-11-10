public class WebTechnician extends Technician{

    public WebTechnician(String name, String surname) {
        super(name,surname);
    }

    void fixWebsite(){ // CHANGE milli
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println("could not do reparations");
        }
        System.out.println("reparations complete");
    }
}
