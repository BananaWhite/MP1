import javax.swing.table.TableRowSorter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Zadanie 1.
        Programmer programmer1 = new Programmer();
        programmer1.setName("Marshall");
        programmer1.setLastName("Mathers");
        programmer1.setFamilyName(null);
        programmer1.setPayment(5400);
        programmer1.setStartShift(LocalDate.now());
        programmer1.setEndShift(LocalDate.MAX);
        programmer1.setTeamManagerName(null);

        ExtensionsContainer.showExtents(Programmer.class);

        //Zadanie 2.
        try {
            ExtensionsContainer.writeToFile(new File("./extents.txt"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ExtensionsContainer.clearExtents();
        System.out.println(ExtensionsContainer.isExtentsMapEmpty());

        try {
            ExtensionsContainer.readFromFile(new File("./extents.txt"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ExtensionsContainer.showAllExtents();

        //Zadanie 3.
        System.out.println();
        System.out.println("Proof of usage a complex type in a class:");
        System.out.println("Programmer.LocalDate \n" +
                programmer1.getShiftStart().getClass() + "\nIs this a primitive type: "
                + programmer1.getShiftStart().getClass().isPrimitive());

        //Zadanie 4.
        System.out.println();
        System.out.println("Proof of usage of a nullable(not obligatory) type:");
        System.out.println("Programmer.teamLeaderName\n" +
                programmer1.getTeamManagerName() + "\nIs this a nullable type: " +
                (programmer1.getTeamManagerName() == null));

        //Zadanie 5.
        TeamLeader teamLeader = new TeamLeader("Paweł", "Koszka",
                null, 5000, LocalDate.now(), LocalDate.now());
        teamLeader.setTeamMembersNames(Arrays.asList(programmer1.getName(), programmer1.getName()));
        System.out.println();
        System.out.println("Proof of usage of a container type: ");
        System.out.println("TeamLeader.teamMembersName<String>: ");
        System.out.println(teamLeader.getTeamMembersNames());

        //Zadanie 6.
        System.out.println();
        System.out.println("Proof of usage of constant type: ");
        System.out.println("TeamLeader implements IPersonalDetails.teamLeaderBonus: ");
        try {
            var field = teamLeader.getClass().getInterfaces()[0].getField("teamLeaderBonus");
            System.out.println(field);
            System.out.println("Is that field constant: " + (field.toString().contains("final")));
        } catch (NoSuchFieldException ignored) {}

        //Zadanie 7.
        System.out.println();
        System.out.println("Proof of usage of derived attribute: ");
        Supplier<Stream<String>> streamSupplier = () -> {
            try {
                return Files.lines(Paths.get("src/Manager.java"));
            } catch (IOException exception) {
                return null;
            }
        };
        System.out.println(streamSupplier.get().skip(66).findFirst().orElse(null));
        System.out.println(streamSupplier.get().skip(67).findFirst().orElse(null));
        System.out.println(streamSupplier.get().skip(68).findFirst().orElse(null));

        //Zadanie 8.
        System.out.println();
        System.out.println("Proof of usage of class method: ");
        var pOfficer1 = new PoliceOfficer("Gregory", LocalDate.now(), "Captain");
        var pOfficer2 = new PoliceOfficer("Hugh", LocalDate.now(), "Mayor");
        var pOfficer3 = new PoliceOfficer("Cuddy", LocalDate.now(), "Captain");
        var pOfficer4 = new PoliceOfficer("Gregory", LocalDate.of(2000, 10, 30), "General");
        System.out.println(PoliceOfficer
                .getPoliceOfficerByPredicate(policeOfficer -> policeOfficer
                .getName().equals("Gregory")));
        System.out.println(PoliceOfficer
                .getPoliceOfficerByPredicate(policeOfficer -> policeOfficer
                .getHireDate().toString().equals(LocalDate.now().toString())));
        System.out.println(PoliceOfficer
                .getPoliceOfficerByPredicate(policeOfficer -> policeOfficer
                .getRank().equals("Captain")));

        //Zadanie 9.
        System.out.println();
        System.out.println("Proof of usage of override method: ");
        System.out.println(Arrays.toString(PoliceOfficer.class.getConstructors()));
    }
}
