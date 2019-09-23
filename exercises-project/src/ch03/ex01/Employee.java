package ch03.ex01;

public class Employee implements Measurable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /*
     * Ex 3.2
     *
     * The exercise asks why we need a cast.
     *
     * It's because Measurable.largest only says that it returns a Measurable
     * -- it could be any Measurable, so we must cast.
     *
     * In the below, there is actually no cast -- because I’ve enhanced
     * Measurable.largest with generics, so that it returns an object of the
     * type contained in the array provided as an argument.
     */
    public static String nameOfHighestPaidEmployee(Employee[] employees) {
        Employee largest = Measurable.largest(employees);
        if (largest == null) {
            return null;
        }
        return largest.getName();
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
}
