/**
 * Controller Class for the MCVPattern
 * Blueprint for the Controller entity
 */
public class Controller {
    private Employee model;
    private View view;

    /**
     *
     * @param model Employee model
     * @param view View view
     * description: initialisation of the controller entity
     */
    public Controller(Employee model, View view) {
        this.model = model;
        this.view = view;
    }

    // setter for employee
    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public void setEmployeeSurname(String surname) {
        model.setSurname(surname);
    }

    public void setEmployeeAddress(String address) {
        model.setAddress(address);
    }

    public void setEmployeePhoneNumber(int phoneNumber) {
        model.setPhoneNumber(phoneNumber);
    }

    public void setEmployeeId(int id) {
        model.setId(id);
    }

    // Update function
    public void updateView() {
        view.printEmpolyeeDetails(model);
    }

}
