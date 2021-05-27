import java.io.Serializable;
import java.time.LocalDate;

public class Programmer extends ExtensionsContainer implements IPersonalDetails, Serializable {
    private String name;
    private String lastName;
    private String familyName;
    private LocalDate shiftStart;
    private LocalDate shiftEnd;
    private double payment;

    public Programmer() {
        super(true);
    }

    public Programmer(String name, String lastName, String familyName, double payment, LocalDate shiftStart, LocalDate shiftEnd) {
        super(true);
        this.name = name;
        this.lastName = lastName;
        this.payment = payment;
        this.familyName = familyName;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public void setStartShift(LocalDate startShift) {
        this.shiftStart = startShift;
    }

    @Override
    public void setEndShift(LocalDate endShift) {
        this.shiftEnd = endShift;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public double getPayment() {
        return payment * netto;
    }

    public LocalDate getShiftStart() {
        return shiftStart;
    }

    public LocalDate getShiftEnd() {
        return shiftEnd;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                ", payment=" + payment +
                '}';
    }
}
