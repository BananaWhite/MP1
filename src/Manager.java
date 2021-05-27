import java.io.Serializable;
import java.time.LocalDate;

public class Manager extends ExtensionsContainer implements IPersonalDetails, Serializable {
    private String name;
    private String lastName;
    private String familyName;
    private double payment;
    private static final Boolean isBachelorDegreeRequired = true;

    public Manager() { super(true); }

    public Manager(String name, String lastName, String familyName, double payment,
                   boolean hasBachelorDegree) throws Exception{
        super(true);
        if(!hasBachelorDegree && isBachelorDegreeRequired) {
            throw new Exception("Manager has to have a bachelor degree at least.");
        }
        this.name = name;
        this.lastName = lastName;
        this.familyName = familyName;
        this.payment = payment;
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
    public void setStartShift(LocalDate startShift) { }

    @Override
    public void setEndShift(LocalDate endShift) { }

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
    public LocalDate getShiftStart() { return null; }

    @Override
    public LocalDate getShiftEnd() { return null; }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", payment=" + payment +
                '}';
    }
}
