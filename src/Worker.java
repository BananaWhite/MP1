import java.io.Serializable;
import java.time.LocalDate;

public class Worker extends ExtensionsContainer implements IPersonalDetails, Serializable {
    private String name;
    private String lastName;
    private String familyName;
    private double payment;
    private LocalDate startShift;
    private LocalDate endShift;

    public Worker(String name, String lastName, String familyName, double payment, LocalDate startShift, LocalDate endShift) {
        super(true);
        this.name = name;
        this.lastName = lastName;
        this.familyName = familyName;
        this.payment = payment;
        this.startShift = startShift;
        this.endShift = endShift;
    }

    Worker() {
        super(true);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public void setStartShift(LocalDate startShift) {
        this.startShift = startShift;
    }

    @Override
    public void setEndShift(LocalDate endShift) {
        this.endShift = endShift;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFamilyName() {
        return familyName;
    }

    @Override
    public double getPayment() {
        return payment * netto;
    }

    @Override
    public LocalDate getShiftStart() {
        return startShift;
    }

    @Override
    public LocalDate getShiftEnd() {
        return endShift;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", payement=" + payment +
                ", startShift=" + startShift +
                ", endShift=" + endShift +
                '}';
    }
}
