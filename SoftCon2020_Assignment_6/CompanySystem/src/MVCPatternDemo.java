import jdk.jshell.execution.Util;

// https://www.geeksforgeeks.org/mvc-design-pattern/
public class MVCPatternDemo {
    public static void main(String[] args) {

        Employee model = retrieveEmployeFromDatabase();
        View view = new View();
        Controller controller = new Controller(model,view);

        System.out.println("1) Create a new employee:");
        controller.updateView();

        System.out.println("2) Print the employee name, surname and ID.");
        System.out.print("Name:");
        view.printName(model.getName());
        System.out.print("Surname:");
        view.printSurname(model.getSurname());
        System.out.print("ID:");
        view.printId(model.getId());


        System.out.println("3) Update the employee address");
        controller.setEmployeeAddress("New Rainbowroad 2");

        System.out.println("4) Print the new address");
        System.out.print("New address: ");
        view.printAddress(model.getAddress());

        System.out.println("5) Update the employee phone number");
        controller.setEmployeePhoneNumber(111111111);

        System.out.print("6) Print the new phone number:");
        view.printPhoneNumber(model.getPhoneNumber());

    }


    /**
     *
     * @return: new employee Mario
     */
    private static Employee retrieveEmployeFromDatabase() {
        // 1) create new employee
        Employee e = new Employee();
        e.setName("Super");
        e.setSurname("Mario");
        e.setAddress("Rainbowroad 17");
        e.setPhoneNumber(100000001);
        e.setId(Utils.generateID());
        return e;
    }
}
