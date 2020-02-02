package photos.brooklyn;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 *
 */
public class FileWriteRead {
    public static void main(String[] args) throws IOException {
        Path path = new File(args[0]).toPath();
        final int limit = Integer.parseInt(args[1]);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
            for (int i = 0; i < limit; i++) {
                writer.println(ThreadLocalRandom.current().nextInt(1000));
            }
        }
        // now the read
        try (Stream<String> fileStream = Files.lines(path)) {
            final long evens = fileStream.filter(s -> Integer.parseInt(s) % 2 == 0).count();
            System.out.printf("%d even numbers out of %d, or %f percent", evens, limit, (evens / (float)limit));
        }
    }
}
