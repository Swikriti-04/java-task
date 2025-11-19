public class Manager extends Employee{
    
    private int teamSize;
    private double projectBonus=0;
    
    public Manager(String name,double salary, String dept){
        
        super(name,salary,dept);
        this.teamSize = teamSize;
        this.projectBonus = 0;
    }
    @Override
    public double calculateSalary(){
       int teamBonus = teamSize*500;
       double managerAllowance = getBaseSalary()*0.20;
       return getBaseSalary()+managerAllowance+teamBonus+projectBonus;
       
    }
    @Override
    public String getRole(){
        return "Manager";
    }
    @Override
    public double getBonus(){
        return teamSize*500;
    }

    public void setProjectBonus(double bonus){
        this.projectBonus = bonus;
    }

    public void setProjectBonus(String bonusText){
         this.projectBonus = Double.parseDouble(bonusText);
    }
    
    public int getTeamSize(){
        return teamSize;

    }

    public double getProjectBonus(){
        return projectBonus;
    }

}