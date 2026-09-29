import org.example.class05.inheritance.Manager;

import java.time.LocalDate;

void main() {
    LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);
    Manager analyticalEngineer = new Manager("01", "Charles Babbage", "Computer Engineer", 10_000.0, fiveYearsAgo, "Mathematics");
    System.out.println(analyticalEngineer.calculateBonus()); // superclass method
    System.out.println(analyticalEngineer.calculateProfitSharing(100_000.0)); // subclass method
    System.out.println(analyticalEngineer.getDepartment()); // getter of subclass variable
}
