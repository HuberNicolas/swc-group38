public class Controller {
    private Employee model;
    private View view;

    public Controller(Employee model, View view) {
        this.model = model;
        this.view = view;
    }

    // setter

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


    public void updateView() {
        view.printEmpolyeeDetails(model);
    }

}
