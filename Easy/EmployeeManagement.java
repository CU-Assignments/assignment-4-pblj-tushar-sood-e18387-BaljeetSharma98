import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
    }

    private static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.print("Enter new Name: ");
                e.setName(scanner.nextLine());
                System.out.print("Enter new Salary: ");
                e.setSalary(scanner.nextDouble());
                return;
            }
        }
        System.out.println("Employee not found");
    }

    private static void removeEmployee() {
        System.out.print("Enter ID to remove: ");
        int id = scanner.nextInt();
        employees.removeIf(e -> e.getId() == id);
    }

    private static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found");
    }
}
