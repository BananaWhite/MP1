import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExtensionsContainer implements Serializable {
    private static Map<Class<? extends ExtensionsContainer>,
            List<ExtensionsContainer>> extents = new Hashtable<>();

    public ExtensionsContainer() { }

    public ExtensionsContainer(boolean isToPerform) {
        if(isToPerform) {
            List<ExtensionsContainer> _extents = null;
            Class<? extends ExtensionsContainer> clazz = this.getClass();

            if(extents.containsKey(clazz)) {
                _extents = extents.get(clazz);
            } else {
                _extents = new ArrayList<>();
                extents.put(clazz, _extents);
            }

            _extents.add(this);
        }
    }

    public static void writeToFile(File file) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file));
        objectOutputStream.writeObject(extents);
    }

    public static void readFromFile(File file) throws IOException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        try {
            extents = (Map<Class<? extends ExtensionsContainer>,
                    List<ExtensionsContainer>>) objectInputStream.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Iterable<? extends ExtensionsContainer> getExtents(
            Class<? extends ExtensionsContainer> clazz) throws ClassNotFoundException {
        if(extents.containsKey(clazz))
            return (Iterable<? extends ExtensionsContainer>) extents.get(clazz);
        throw new ClassNotFoundException("Couldn't fetch the extensions");
    }

    public static void showExtents(Class<? extends ExtensionsContainer> clazz) {
        extents.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .values()
                .stream()
                .collect(Collectors.toMap(
                        item -> item.get(0).getValue(),
                        item -> new ArrayList<>(
                                item.stream()
                                .map(r -> {
                                    if(r.getKey().getName().equals(clazz.getName()))
                                        return r.getKey();
                                    else
                                        return null;
                                })
                                .collect(Collectors.toList())
                        )
                )).forEach((e, f) -> System.out.println(e + " " + f));
    }
}
