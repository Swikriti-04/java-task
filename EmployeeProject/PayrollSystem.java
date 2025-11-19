import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayrollSystem {

    private String companyName;
    private List<Employee> employees;


    public PayrollSystem(String companyName) {
        this.companyName = companyName;

    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    
    public boolean removeEmployee(String id) {
        return employees.removeIf(emp -> emp.generateEmployeeId().equals(id));
    }

  
    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getfirstName().toLowerCase().contains(name.toLowerCase()) ||
                emp.getlastName().toLowerCase().contains(name.toLowerCase())) {
                result.add(emp);
            }
        }
        return result;
    }


    public List<Employee> searchByRole(String role) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getRole().toLowerCase().contains(role.toLowerCase())) {
                result.add(emp);
            }
        }
        return result;
    }

  
    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        return total;
    }

    public void displayAllEmployees() {
        System.out.println("Employees of " + companyName);
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.generateEmployeeId() +" | Name: " + emp.getfirstName() + " " + emp.getlastName() + " | Role: " + emp.getRole() + " | Salary: " + emp.calculateSalary());
        }
    }
    public void generateSummaryReport() {
        System.out.println("Summary Report for " + companyName);
        Map<String, Integer> roleCounts = new HashMap<>();
        Map<String, Double> roleSalaries = new HashMap<>();

        for (Employee emp : employees) {
            String role = emp.getRole();
            roleCounts.put(role, roleCounts.getOrDefault(role, 0) + 1);
            roleSalaries.put(role, roleSalaries.getOrDefault(role, 0.0) + emp.calculateSalary());
        }

        for (String role : roleCounts.keySet()) {
            System.out.println("Role: " + role + " | Count: " + roleCounts.get(role) + " | Total Payroll: " + roleSalaries.get(role));
        }

        System.out.println("Total Payroll: " + calculateTotalPayroll());
    }
}
