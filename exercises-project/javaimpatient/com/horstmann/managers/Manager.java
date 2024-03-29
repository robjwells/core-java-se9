package javaimpatient.com.horstmann.managers;

import javaimpatient.com.horstmann.employees.Employee;

public class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public double getSalary() { 
        return salary + bonus; // Ok to access protected salary variable
    }
} 
