public class WebTechnician extends Technician{

    public WebTechnician() {

    }
    void fixWebsite(){
        try {
            Thread.sleep(30000);
        } catch(InterruptedException e) {
            System.out.println("could not do reparations");
        }
        System.out.println("reparations complete");
    }
}
