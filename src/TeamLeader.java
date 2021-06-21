import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TeamLeader extends ExtensionsContainer implements IPersonalDetails, Serializable {
    private String name;
    private String lastName;
    private String familyName;
    private List<String> teamMembersNames = null;
    private double payment;
    private LocalDate startShift;
    private LocalDate endShift;

    public TeamLeader(String name, String lastName, String familyName,
                      double payment, LocalDate startShift, LocalDate endShift) {
        this.name = name;
        this.lastName = lastName;
        this.familyName = familyName;
        this.payment = payment;
        this.startShift = startShift;
        this.endShift = endShift;
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

    public void setTeamMembersNames(List<String> teamMembersNames) {
        this.teamMembersNames = teamMembersNames;
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

    public List<String> getTeamMembersNames() {
        return teamMembersNames;
    }

    @Override
    public double getPayment() {
        return payment;
    }

    @Override
    public LocalDate getShiftStart() {
        return startShift;
    }

    @Override
    public LocalDate getShiftEnd() {
        return endShift;
    }


}
