
import javax.lang.model.util.ElementScanner14;

public abstract class Developer extends Employee {

    private String programmingLanguage;
    private int projectsCompleted;
    private String skillLevel; // senior, mid or junior
    private double projectBonus;

    public Developer(String fullName, double baseSalary, String department, 
                     String programmingLanguage, String skillLevel) {
        super(fullName, baseSalary, department);
        this.programmingLanguage = programmingLanguage;
        this.skillLevel = skillLevel;
        this.projectsCompleted = 0;
        this.projectBonus = 0;
    }

    @Override
    public double calculateSalary() {
        double allowance = 0;

        if (skillLevel.equalsIgnoreCase("Senior")) {
            allowance = getBaseSalary() * 0.25;
        } else if (skillLevel.equalsIgnoreCase("Mid")) {
            allowance = getBaseSalary() * 0.15;
        } else {
            allowance = getBaseSalary() * 0.05;
        }

        return getBaseSalary() + allowance + projectBonus;
    }

    
    @Override
    public String getRole(){
        return skillLevel+" Developer";

    }

    @Override
    public double getBonus(){
        return projectsCompleted * 300;

   }
    
    public void completeProject(){
        projectsCompleted++;
        projectBonus+= 300;
    }
    
    public void completeProject(int number){
        projectsCompleted += number;
        projectBonus += number*300;
    }
    
    public String generateEmail(){
        String firstInitial =getfirstName().charAt(0)+"";
        String last = getlastName().toLowerCase()+"";
        return firstInitial+last+"@techcorp.com";

    }


}
