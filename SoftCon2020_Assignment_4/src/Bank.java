import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> Customers;
    private ArrayList<Employee> Employees;

    public Bank(){
        this.Customers = new ArrayList<Customer>();
        this.Employees = new ArrayList<Employee>();
    }

    public ArrayList<Customer> getCustomers() {
        return Customers;
    }

    public ArrayList<Employee> getEmployees() {
        return Employees;
    }


    public void add_Customer(Customer c){
        this.Customers.add(c);
    }

    public void add_Employee(Employee em, ArrayList<Employee> list){
        if (em instanceof SectionChief){
            try {
                for(Employee employee : list ){
                    if (employee instanceof SectionChief){
                        if (((SectionChief) employee).getCity().equals(((SectionChief) em).getCity())){
                            throw new IllegalArgumentException("There is already a SectionChief working in "+((SectionChief) em).getCity());
                        }
                    }
                }
                this.Employees.add(em);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
        }}
        else{ this.Employees.add(em);}
    }
}
