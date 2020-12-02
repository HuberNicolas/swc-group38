// https://www.geeksforgeeks.org/mvc-design-pattern/
public class MVCPatternDemo {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Employee model = retrieveEmployeFromDatabase();
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.updateView();
        controller.setEmployeeName("Locatelli");
        controller.setEmployeeSurname("Luigi");
        controller.updateView();
    }


    private static Employee retrieveEmployeFromDatabase() {
        Employee e = new Employee();
        e.setName("Super");
        e.setSurname("Mario");
        e.setAddress("Rainbowroad 17");
        e.setPhoneNumber(623482790);
        e.setId(12345678);
        return e;
    }
}
