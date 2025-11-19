public class Main {
    public static void main(String[] args) {
        PayrollSystem system = new PayrollSystem("TechCorp");

        Developer dev1 = new Developer("Swikriti Mondal",5000, "IT", "Junior");
        dev1.completeProject(2);

        Designer des1 = new Designer("Saurabh",4000, "Design", "Figma", "UI");
        des1.completeDesign(); 

        Manager mgr1 = new Manager("Abhijit",8000, "Management");

        // Add employees
        system.addEmployee(dev1);
        system.addEmployee(des1);
        system.addEmployee(mgr1);

        // Display all employees
        system.displayAllEmployees();

        // Search by name
        system.searchByName("Swikriti");

        // Total payroll
        System.out.println("Total Payroll: " + system.calculateTotalPayroll());

        // Encapsulation demonstration
        System.out.println("Before raise, Swikriti's salary: " + dev1.getBaseSalary());
        dev1.getBaseSalary();
        System.out.println("After raise, swikriti's salary: " + dev1.getBaseSalary());
    }
}
