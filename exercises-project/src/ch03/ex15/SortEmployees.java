package ch03.ex15;

import ch03.ex01.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class SortEmployees {
    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Adam", 4),
                new Employee("Alpha", 1),
                new Employee("Charlie", 3),
                new Employee("Bravo", 1),
        };

        Comparator<Employee> bySalaryThenNameComparator = Comparator
                .comparing(Employee::getSalary)
                .thenComparing(Employee::getName);

        System.out.println("Ascending");
        Employee[] bySalaryThenNameAscending = employees.clone();
        Arrays.sort(bySalaryThenNameAscending, bySalaryThenNameComparator);
        for (Employee e : bySalaryThenNameAscending) {
            System.out.println(e);
        }

        System.out.println("\nDescending");
        Employee[] bySalaryThenNameDescending = employees.clone();
        Arrays.sort(bySalaryThenNameDescending, bySalaryThenNameComparator.reversed());
        for (Employee e : bySalaryThenNameDescending) {
            System.out.println(e);
        }
    }
}
