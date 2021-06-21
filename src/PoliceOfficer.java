import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PoliceOfficer {
    private static List<PoliceOfficer> extent = new LinkedList<>();
    private String name;
    private LocalDate hireDate;
    private String rank;

    public PoliceOfficer() {}

    public PoliceOfficer(String name, LocalDate hireDate, String rank) {
        this.name = name;
        this.hireDate = hireDate;
        this.rank = rank;

        extent.add(this);
    }

    public static List<PoliceOfficer> getPoliceOfficerByPredicate(Predicate<PoliceOfficer> predicate) {
        return extent.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
    }

    public static void changeRank(String rank) {
        for(var officer : extent) {
            officer.setRank(rank);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "PoliceOfficer{" +
                "name='" + name + '\'' +
                ", hireDate=" + hireDate +
                ", rank='" + rank + '\'' +
                '}';
    }
}
