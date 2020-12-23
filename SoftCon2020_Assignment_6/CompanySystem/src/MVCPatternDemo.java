/**
 * Demo Class for the MCVPattern
 */
public class MVCPatternDemo {
    public static void main(String[] args) {

        // Demo program to show, how the MVC-Pattern works
        Employee model = retrieveEmployeFromDatabase(); // initialise new model oj
        View view = new View(); // initialise new view obj
        Controller controller = new Controller(model,view); // initialise new controller obj

        // Generate new employee
        System.out.println("1) Create a new employee:");
        controller.updateView();

        // Check the details of the new employee
        System.out.println("2) Print the employee name, surname and ID.");
        System.out.print("Name:");
        view.printName(model.getName());
        System.out.print("Surname:");
        view.printSurname(model.getSurname());
        System.out.print("ID:");
        view.printId(model.getId());

        // Update the employee and show changes
        System.out.println("3) Update the employee address");
        controller.setEmployeeAddress("New Rainbowroad 2");

        System.out.println("4) Print the new address");
        System.out.print("New address: ");
        view.printAddress(model.getAddress());

        System.out.println("5) Update the employee phone number");
        controller.setEmployeePhoneNumber(781112233);

        System.out.print("6) Print the new phone number:");
        view.printPhoneNumber(model.getPhoneNumber());
    }
    /**
     *
     * @return: new employee Mario
     * description: this functions returns new instance "Mario" of
                    the employee class.
     */
    private static Employee retrieveEmployeFromDatabase() {
        // 1) create new employee
        Employee e = new Employee();
        e.setName("Super");
        e.setSurname("Mario");
        e.setAddress("Rainbowroad 17");
        e.setPhoneNumber(797681947);
        e.setId(Utils.generateID());
        return e;
    }
}
