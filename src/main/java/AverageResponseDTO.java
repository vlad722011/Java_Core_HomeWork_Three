import lombok.Data;
import lombok.Builder;


@Data
@Builder
public class AverageResponseDTO {
    private double averageSalary;
    private double averageAge;
    private int averageLettersInFirstName;
    private int averageLettersInLastName;
}
