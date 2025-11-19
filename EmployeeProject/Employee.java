public abstract class Employee{
    private String employeeId;
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private double baseSalary;
    private String department;

    public Employee(String fullName, double baseSalary, String department){
         this.fullName = fullName;
         this.baseSalary = baseSalary;
         this.department = department;
         parseName(fullName);
         this.employeeId = generateEmployeeId();

    }
    
    protected void parseName(String fullName) {

         String[] parts = fullName.trim().split(" ");

     
         if (parts.length == 1) {
               firstName = parts[0];
         } else if (parts.length == 2) {
               firstName = parts[0];
               lastName = parts[1];
         } else if (parts.length >= 3) {
               firstName = parts[0];
               middleName= parts[1];
               lastName = parts[parts.length - 1];
         }
         System.out.println("First Name: " + firstName);
         System.out.println("Middle Name: " + middleName);
         System.out.println("Last Name: " + lastName);


    }

    public String generateEmployeeId(){
          
          return getRole().substring(0,3).toUpperCase()+"_"+firstName.charAt(0)+lastName.charAt(0)+"_5472";
    }
    public String formatName(){
         return fullName.toUpperCase();
    }
    public String getInitials(){
         return ""+ firstName.charAt(0)+lastName.charAt(0);
    }
    public String generatePayslip(){
         
         return "ID: "+employeeId+"\nName: "+fullName+"\nRole"+getRole()+"\nSalary"+calculateSalary();

    }

    public abstract double calculateSalary();
    public abstract String getRole();
    public abstract double getBonus();
    public String getfirstName(){return firstName;}
    public String getlastName(){return lastName;}
    public double getBaseSalary(){return baseSalary;}

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

}

