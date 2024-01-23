import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.Comparator;

public class Main {


    public static double findAverageSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(x -> x.getSalary().doubleValue())
                .average().orElseThrow();
    }

    public static double findAverageAge(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(x -> (double) x.getAge())
                .average().orElseThrow();
    }


    public static AverageResponseDTO getAverage(List<Employee> employees) {
        return AverageResponseDTO.builder()
                .averageAge(employees.stream()
                        .mapToDouble(x -> (double) x.getAge())
                        .average().orElseThrow())
                .averageSalary(employees.stream()
                        .mapToDouble(x -> x.getSalary().doubleValue())
                        .average().orElseThrow())
                .averageLettersInFirstName((int) employees.stream()
                        .mapToInt(x -> x.getFirstName().length())
                        .average().orElseThrow())
                .averageLettersInLastName((int) employees.stream()
                        .mapToInt(x -> x.getLastName().length())
                        .average().orElseThrow())
                .build();
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Bursaev", "Vladislav",
                LocalDate.of(1972, 7, 22),
                "devops", "+7-953-912-81-12",
                BigDecimal.valueOf(1000));

        Employee employee2 = new Employee("Bursaeva", "Zlata",
                LocalDate.of(1972, 7, 22),
                "bossYO", "+7-923-422-80-24",
                BigDecimal.valueOf(1500));

        Employee employee3 = new Employee("Bursaeva", "Svetlana",
                LocalDate.of(1971, 6, 25),
                "analyst", "+7-923-422-18-98",
                BigDecimal.valueOf(1300));

        Employee employee4 = new Employee("Bursaev", "Daniil",
                LocalDate.of(1995, 6, 19),
                "teamLead", "+7-913-582-28-16",
                BigDecimal.valueOf(1400));

        Employee employee5 = new Employee("Petrov", "Ivan",
                LocalDate.of(1979, 3, 12),
                "study", "+7-813-782-38-19",
                BigDecimal.valueOf(800));

        Employee supervisor = new Supervisor("Ivan", "Ivanov",
                LocalDate.of(1990, 2, 28),
                "supervisor", "+7-999-888-88-88",
                BigDecimal.valueOf(2500));


        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1,
                employee2, employee3, employee4, employee5, supervisor));

        System.out.println("_________________________________________________________");
        System.out.println("Начальные зарплаты сотрудников компании:");
        for (Employee employee : employees) {
            System.out.println(employee.printInfoOfEmployee());

        }

        System.out.println("_________________________________________________________");
        System.out.println("Зарплаты сотрудников после повышения сотрудникам старше 45 лет:");
        Supervisor.increaseSalaryForOlderEmployees(employees, 45, 250.0);
        for (Employee employee : employees) {
            System.out.println(employee.printInfoOfEmployee());
        }


        System.out.println("_________________________________________________________");
        System.out.println("Зарплаты сотрудников после повышения всем, кроме руководителя:");
        Supervisor.increaseSalaryForEmployees(employees, 300);
        for (Employee employee : employees) {
            System.out.println(employee.printInfoOfEmployee());
        }


        System.out.println("_________________________________________________________");
        System.out.println("Методы для поиска различных средних значений:");
        System.out.println("Average salary-> " + findAverageSalary(employees));
        System.out.println("Average age-> " + findAverageAge(employees));
        System.out.println(getAverage(employees));
        System.out.println("_________________________________________________________");


        System.out.println("Сравниваем даты при помощи компаратора:");

        /**
         * Метод сравнивающий даты рождения сотрудников возвращает число типа int.
         * Если если метод возвращает отрицательное число, значит текущий сотрудник старше
         * сотрудника, с которым его сравнивают по дате рождения.
         * Если метод возвращает ноль - сотрудники одинакового возраста.
         * Если возвращаемое число положительное - текущий сотрудник младше сотрудника
         * с которым происходит сравнение по дате рождения.
         */

        System.out.println(employee1.compareTo(employee2));
        System.out.println(employee1.compareTo(employee3));
        System.out.println(Employee.compareTo2(1989, 3,23, employee4));
        System.out.println(Employee.compareTo2(1979, 6,30, employee5));
        System.out.println(Employee.compareTo2(1990,4,25, supervisor));


    }

}


