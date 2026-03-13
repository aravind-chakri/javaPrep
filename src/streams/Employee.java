package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
   private int id;
   private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {

    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee(21, "Aravind", "IT", 1000.0, 26),
                new Employee(28, "Damodara", "Resource Management", 3000.0, 42),
                new Employee(2, "Murali", "IT", 2000.0, 28),
                new Employee(43, "Riya", "HR", 1000.0, 38),
                new Employee(5, "Rohit", "Sales", 2000.0, 36),
                new Employee(49, "Praveen", "IT", 1500.0, 25),
                new Employee(45, "Namita", "Sales", 1000.0, 26),
                new Employee(12, "Priya", "Resource Management",2500.0, 35)
        );


        // Find Second-highest salary
        Optional<String> secondHighestSalary = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(emp -> emp.getName() + ": " + emp.getSalary()).skip(1).findFirst();

        System.out.println("Second highest salary is: " + secondHighestSalary);




        // Highest paid employee in each department
        Map<String, Employee> highestPaidEmpInEachDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                          Optional<Employee> employee =  list.stream()
                                    .max(Comparator.comparingDouble(Employee::getSalary));
                          return employee.get();
                        } )));

        for(Map.Entry e : highestPaidEmpInEachDept.entrySet()) {
            System.out.println("Highest paid employee in each department: " + e.getKey() + " " + e.getValue());
        }






        // Group employee by Department
        Map<String, List<Employee>> employeeListByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeeListByDept);




        //count employees in each department
        Map<String, Long> employeeCountByDept = employeeList.stream()
                                    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        for(Map.Entry e : employeeCountByDept.entrySet()) {
            System.out.println(e.getKey() + " has " + e.getValue() + " employees");
        }





        //average salary of each department
        Map<String, Double> averageSalOfEachDept = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        averageSalOfEachDept.forEach((dept, average) ->
                System.out.println(dept + " has an average salary of " + average));

        


        
        
        //Find whose salary is above the average salary
        OptionalDouble averageSalary = employeeList.stream().mapToDouble(Employee::getSalary).average();
        System.out.println("Average is: " + averageSalary);

        List<Employee> employeesEarningAboveAvgsalary = employeeList.stream().filter(
                emp -> emp.getSalary() > averageSalary.getAsDouble()).collect(Collectors.toList());

        System.out.println(employeesEarningAboveAvgsalary);





        //Find whose salary is greater than their dept avg salary

        Map<String, List<Employee>> empSalaryAbvDeptAvg = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(), list -> {
                            double average = list.stream().mapToDouble(Employee::getSalary).average().orElse(0);
                            return list.stream().filter(emp -> emp.getSalary() >= average).collect(Collectors.toList());
                        })));

        System.out.println(empSalaryAbvDeptAvg);





        //Partitioning Employee by salary greater than 20000
        Map<Boolean, List<Employee>> empPartition = employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 2000));
        System.out.println(empPartition);





        // Find youngest-employee in each department
        Map<String, Optional<Employee>> youngestEmpByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getAge))));
        youngestEmpByDept.forEach((dept, employee) ->
                System.out.println(employee.get().getName() + " is the youngest from " + dept + " department"));







        // Find department with highest-total salary
        Map<String, Double> deptTotalSalaries = employeeList.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        String highestTotalSalaryDept = deptTotalSalaries.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        System.out.println(highestTotalSalaryDept);





        //Find employees Sorted by salary and then age
        List<Employee> employeeSortedBySalaryAndThenAge = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("List of employees sorted by salary and then age: " + employeeSortedBySalaryAndThenAge);
    }
}
