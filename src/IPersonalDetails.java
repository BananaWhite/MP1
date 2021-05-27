import java.time.LocalDate;

public interface IPersonalDetails {
    static final double netto = 0.75;
    void setName(String name);
    void setLastName(String lastName);
    void setFamilyName(String familyName);
    void setPayment(double payment);
    void setStartShift(LocalDate startShift);
    void setEndShift(LocalDate endShift);

    String getName();
    String getLastName();
    String getFamilyName();
    double getPayment();
    LocalDate getShiftStart();
    LocalDate getShiftEnd();
}
