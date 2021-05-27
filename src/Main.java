import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Zadanie 1.
        Programmer programmer1 = new Programmer();
        Programmer programmer2 = new Programmer();
        ExtensionsContainer.showExtents(Programmer.class);

        //Zadanie 2.
        try {
            ExtensionsContainer.writeToFile(new File("./extents.txt"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
