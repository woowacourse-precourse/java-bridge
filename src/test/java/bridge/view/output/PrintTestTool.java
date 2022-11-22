package bridge.view.output;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class PrintTestTool {

    private PrintStream standardOut;
    private OutputStream captor;

    protected String output() {
        return captor.toString().trim();
    }

    @BeforeEach
    protected final void initializeTest() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }
}
