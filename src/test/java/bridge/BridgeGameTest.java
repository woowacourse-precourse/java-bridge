package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class BridgeGameTest {

    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);


    @BeforeEach
    void setUp() {
        System.setOut(printStream);

    }

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }
}
