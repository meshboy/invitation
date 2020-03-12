import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public String readFile(final String fileName) throws FileNotFoundException {
        final File file = new File(fileName);
        final Scanner scanner = new Scanner(file);

        final StringBuilder builder = new StringBuilder("[");

        String prefix = "";
        while (scanner.hasNextLine()) {
            builder.append(prefix);
            prefix = ",";
            builder.append(scanner.nextLine());
        }
        scanner.close();
        return builder.append("]").toString();
    }
}
