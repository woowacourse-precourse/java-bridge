package bridge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {
    @Test
    void printMapTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();
        outputView.printMap(List.of("U", "D", "D"), List.of("U", "U", "D"));
        assertThat(out.toString()).contains("[ O | X |   ]\n[   |   | O ]");
    }
}