// Base class
class Employee {
    protected String name;
    protected int employeeId;
    protected double salary;
    
    // Constructor
    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }
    
    // Method to display salary
    public void DisplaySalary() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Current Salary: $" + salary);
    }
}

// Derived class 1: FullTimeEmployee
class FullTimeEmployee extends Employee {
    private double hikePercentage = 50.0;
    
    // Constructor
    public FullTimeEmployee(String name, int employeeId, double salary) {
        super(name, employeeId, salary);
    }
    
    // Method to calculate salary with 50% hike
    public void CalculateSalary() {
        System.out.println("\n=== FULL-TIME EMPLOYEE ===");
        System.out.println("Salary Before Hike: $" + salary);
        
        double increment = salary * (hikePercentage / 100);
        salary = salary + increment;
        
        System.out.println("Hike Percentage: " + hikePercentage + "%");
        System.out.println("Increment Amount: $" + increment);
        System.out.println("Salary After Hike: $" + salary);
    }
}

// Derived class 2: InternEmployee
class InternEmployee extends Employee {
    private double hikePercentage = 25.0;
    
    // Constructor
    public InternEmployee(String name, int employeeId, double salary) {
        super(name, employeeId, salary);
    }
    
    // Method to calculate salary with 25% hike
    public void CalculateSalary() {
        System.out.println("\n=== INTERN EMPLOYEE ===");
        System.out.println("Salary Before Hike: $" + salary);
        
        double increment = salary * (hikePercentage / 100);
        salary = salary + increment;
        
        System.out.println("Hike Percentage: " + hikePercentage + "%");
        System.out.println("Increment Amount: $" + increment);
        System.out.println("Salary After Hike: $" + salary);
    }
}

// Main class
public class EmployeeDemo_2 {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("HIERARCHICAL INHERITANCE DEMO");
        System.out.println("===================================");
        
        // Creating FullTimeEmployee object
        FullTimeEmployee ft = new FullTimeEmployee("John Smith", 101, 50000);
        ft.DisplaySalary();
        ft.CalculateSalary();
        
        System.out.println("\n-----------------------------------");
        
        // Creating InternEmployee object
        InternEmployee intern = new InternEmployee("Alice Johnson", 201, 20000);
        intern.DisplaySalary();
        intern.CalculateSalary();
        
        System.out.println("\n===================================");
    }
}