import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // toString for easy printing
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeProcessor {

    public static void main(String[] args) {
        // Sample dataset
        List<Employee> employees = Arrays.asList(
            new Employee("Becky", 40, "Finance", 100000),
            new Employee("Li", 38, "Operations", 120000),
            new Employee("Sandra", 45, "Sales", 95000),
            new Employee("Kent", 25, "Operations", 105000),
            new Employee("Stone", 30, "Finance", 72000)
        );

        // Function to concatenate name and department
        Function<Employee, String> nameAndDept = (Employee e) -> e.getName() + " - " + e.getDepartment();

        // Generate collection of concatenated strings
        List<String> nameDeptList = employees.stream()
                                             .map(nameAndDept)
                                             .collect(Collectors.toList());

        System.out.println("Concatenated Name and Department List:");
        nameDeptList.forEach(System.out::println);

        // Calculate average salary
        double averageSalary = employees.stream()
                                        .mapToDouble(Employee::getSalary)
                                        .average()
                                        .orElse(0.0);

        System.out.println("\nAverage Salary: " + averageSalary);

        // Filter employees by age > 30
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                                                    .filter(e -> e.getAge() > ageThreshold)
                                                    .collect(Collectors.toList());

        System.out.println("\nEmployees with age > " + ageThreshold + ":");
        filteredEmployees.forEach(System.out::println);
    }
}
