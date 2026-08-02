import java.util.LinkedHashMap;
import java.util.Map;

public class Dummy {

    public static void main(String[] args) {

        // true = access-order
        LinkedHashMap<Integer, String> map =
                new LinkedHashMap<>(16, 0.75f, true);

        // Add elements
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        System.out.println("After insertion:");
        System.out.println(map);

        // Access key 1
        map.get(1);

        System.out.println("After get(1):");
        System.out.println(map);

        // Access key 2
        map.get(2);

        System.out.println("After get(2):");
        System.out.println(map);

        // Add another element
        map.put(4, "D");

        System.out.println("After put(4, D):");
        System.out.println(map);
    }
}