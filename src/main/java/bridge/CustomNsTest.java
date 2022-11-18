package bridge;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class CustomNsTest {
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        String tmpCaptor = captor.toString().trim();
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        return tmpCaptor;
    }

    protected void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
