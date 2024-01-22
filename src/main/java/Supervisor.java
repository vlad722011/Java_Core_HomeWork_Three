import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
class Supervisor extends Employee {
    private static String firstName;
    private static String lastName;
    private static LocalDate birthdayDate;
    private static String position;
    private static String phone;
    private static BigDecimal salary;
    private static int age;


    public Supervisor(String firstName, String lastName, LocalDate birthdayDate, String position, String phone, BigDecimal salary) {
        super(firstName, lastName, birthdayDate, position, phone, salary);
    }

    public static void increaseSalaryForEmployees(List<Employee> employees, int value) {
        for (Employee employee : employees){
            if(employee.getPosition() != "supervisor") {
                employee.setSalary(employee.getSalary().add(BigDecimal.valueOf(value)));
            }
        }
    }

    public static void increaseSalaryForOlderEmployees (List<Employee> employees,int olderAge, double value) {
        for (Employee employee : employees) {
            if (employee.getAge() > olderAge) {
                employee.setSalary(employee.getSalary().add(BigDecimal.valueOf(value)));
            }

        }
    }

    public int getAge() {
        return super.getAge();
    }


}



