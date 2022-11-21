package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class OutputViewTest {
    private OutputView outputView;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream defaultOutput = System.out;

    @BeforeEach
    void setup(){
        outputView = new OutputView();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restore(){
        System.setOut(defaultOutput);
    }

    @Test
    void printMap() {
        List<String> bridge = List.of("U","D","D");
        List<String> userInput = List.of("U","D","D");

        outputView.printMap(bridge,userInput);
        assertThat(output.toString()).contains("[ O |   |   ]\n[   | O | O ]");

    }
}