package photos.brooklyn.lang;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        // relativitize
        Path a = Paths.get("../d/a.txt");
        Path b = Paths.get("../d/b.txt");
        System.out.println(a.relativize(b));
    }
}
