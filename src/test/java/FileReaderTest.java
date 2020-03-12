import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class FileReaderTest {
    private FileReader mFileReader;

    @Before
    public void setup() {
        mFileReader = new FileReader();
    }

    @Test(expected = FileNotFoundException.class)
    public void validate_file_not_found_exception_is_thrown_when_file_is_not_found() throws FileNotFoundException {
        mFileReader.readFile("randomFile");
    }
}
