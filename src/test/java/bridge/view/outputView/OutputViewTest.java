package bridge.view.outputView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;

public class OutputViewTest {

    private OutputStream captor;

    @BeforeEach
    void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }
    protected String output() {
        return captor.toString().trim();
    }
}
