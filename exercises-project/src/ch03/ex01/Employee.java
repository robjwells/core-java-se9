package ch03.ex01;

public class Employee implements Measurable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    /*
     * Ex 3.2
     *
     * The exercise asks why we need a cast.
     *
     * It's because Measurable.largest only says that it returns a Measurable
     * -- it could be any Measurable, so we must cast.
     */
    public static String nameOfHighestPaidEmployee(Employee[] employees) {
        Measurable largest = Measurable.largest(employees);
        if (largest == null) { return null; }
        return ((Employee) largest).getName();
    }
}
