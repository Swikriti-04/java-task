public abstract class Designer extends Employee{

    private String designTool;
    private int designsCompleted;
    private String specialization;
    private double designBonus;

    public Designer(String fullName, double baseSalary, String department,String designTool, String specialization){
        super(fullName, baseSalary, department);
        this.designTool = designTool;
        this.specialization = specialization;
        this.designsCompleted = 0;
        this.designBonus= 0;

    }
    @Override
    public double calculateSalary(){
    double allowance = getBaseSalary() * 0.15;
    return getBaseSalary() + allowance + designBonus;
    }

    @Override
    public String getRole(){
        return specialization + "Designer";
    }
    
    @Override
    public double getBonus(){
        return designsCompleted * 250;

    }

    public void completeDesign(){
        designsCompleted ++;
        designBonus+=250;
    }
    
    public void completeDesign(int count){
        designsCompleted+=count;
        designBonus+= count*250;
        
    }

    public String generatePortfolioURL(){
        String first = getfirstName().toLowerCase();
        String last = getlastName().toLowerCase();
        return "https://portfolio.techcorp.com/"+first+last;
    }

    public String createSignature(){
        return "✎" + getInitials()+ " | " + designTool + " | " + specialization;
    }
}