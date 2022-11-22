package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

public class InOutStreamTest {

    private PrintStream standardOut;
    private OutputStream outputStream;

    private InputStream standardIn;

    @BeforeEach
    protected final void initiallyAct() {
        standardIn = System.in;
        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    protected final void finallyAct() {
        System.setIn(standardIn);
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected String output() {
        return outputStream.toString().trim();
    }

    protected void input(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }
}
