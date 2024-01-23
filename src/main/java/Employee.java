import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    private String firstName;
    private String lastName;
    private LocalDate birthdayDate;
    private String position;
    private String phone;
    private BigDecimal salary;
    private int age;

    public Employee(String firstName, String lastName, LocalDate birthdayDate,
                    String position, String phone, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
    }

    public int getAge() {
        LocalDate dateNow = LocalDate.now();
        int dayOfYearsBirthday = birthdayDate.getDayOfYear();
        int dayOfYearsNow = dateNow.getDayOfYear();
        if (dayOfYearsNow < dayOfYearsBirthday) {
            return dateNow.getYear() - birthdayDate.getYear() - 1;
        } else {
            return dateNow.getYear() - birthdayDate.getYear();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("сотрудник: ");
        sb.append(lastName).append(" ");
        sb.append(firstName).append(", ");
        sb.append("возраст ").append(getAge()).append(", ");
        sb.append("должность - ").append(position).append(", ");
        sb.append("зар. плата - ").append(salary).append(".");
        return sb.toString();
    }

    public String printInfoOfEmployee() {
        return this.toString();
    }


    public int compareTo(Employee employee) {
        LocalDate curentEmployeeDate = this.getBirthdayDate();
        LocalDate otherEmployeeDate = employee.getBirthdayDate();
        return curentEmployeeDate.compareTo(otherEmployeeDate);
    }

    public static int compareTo2(int yyyy, int mm, int dd, Employee employee) {
        LocalDate otherDate = LocalDate.of(yyyy, mm, dd);
        LocalDate employeeDate = employee.getBirthdayDate();
        return otherDate.compareTo(employeeDate);
    }
}




