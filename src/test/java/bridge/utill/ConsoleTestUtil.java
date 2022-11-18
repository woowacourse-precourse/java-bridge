package bridge.utill;

import java.io.*;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleTestUtil {
    public <T> void testOutput(String input, String ouput, Supplier<T> function) {
        PrintStream defaultOut = System.out;
        OutputStream out = beforeTestOutput();

        setInput(input);
        function.get();
        assertThat(out.toString()).contains(ouput);

        printResult(defaultOut, out);
    }

    private void printResult(PrintStream defaultOut, OutputStream out) {
        String output = out.toString();
        System.setOut(defaultOut);
        System.out.println(output);
    }

    private OutputStream beforeTestOutput() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }

    public void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
