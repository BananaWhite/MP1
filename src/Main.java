import javax.swing.table.TableRowSorter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

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
    }
}
