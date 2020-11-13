import java.util.ArrayList;
/**
 * CLASS BANK
 * class for storing all human entities
 * models an bank containing
 * customers, employees and technicians
 */
public class Bank {
    private ArrayList<Customer> Customers;
    private ArrayList<Employee> Employees;

    // Constructor
    public Bank(){
        this.Customers = new ArrayList<Customer>();
        this.Employees = new ArrayList<Employee>();
    }

    // Getters and Setters

    // Getter
    public ArrayList<Customer> getCustomers() {
        return Customers;
    }

    //Getter
    public ArrayList<Employee> getEmployees() {
        return Employees;
    }


    /**
     * @param c                         customer, who should be added to the global (bank) list, containing all the customers
     * description                      adding a valid customer to the global bank list
     */
    public void add_Customer(Customer c){
        this.Customers.add(c);
    }

    /**
     * @param em                        employee, who should be added to the global (bank) list, containing all employees
     * @param list                      global bank list with all the employees in it
     * description                      adding a valid employee to the global bank list
     *                                  secures the property for a section chief
     */
    public void add_Employee(Employee em, ArrayList<Employee> list){
        // only on SectionChief per city
        if (em instanceof SectionChief){
            try {
                // search
                for(Employee employee : list ){
                    // compare
                    if (employee instanceof SectionChief){
                        if (((SectionChief) employee).getCity().equals(((SectionChief) em).getCity())){
                            // invalid
                            throw new IllegalArgumentException("There is already a SectionChief working in "+((SectionChief) em).getCity());
                        }
                    }
                }
                // add
                this.Employees.add(em);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
        }}
        else{ this.Employees.add(em);}
    }
}
