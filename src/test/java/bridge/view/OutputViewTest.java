package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class OutputViewTest {

    private OutputView outputView = new OutputView();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void printMap() {
        List<List<StringBuilder>> moveTable = new ArrayList<>();
        moveTable.add(new ArrayList<>());
        moveTable.add(new ArrayList<>());

        outputView.printMap(List.of("D", "U", "D", "D"), 0, "D", moveTable);
        outputView.printMap(List.of("D", "U", "D", "D"), 1, "U", moveTable);
        outputView.printMap(List.of("D", "U", "D", "D"), 2, "D", moveTable);
        outputView.printMap(List.of("D", "U", "D", "D"), 3, "U", moveTable);
        Assertions.assertThat(outContent.toString()).contains(
                "[   ]",
                "[ O ]",
                "[   | O ]",
                "[ O |   ]",
                "[   | O |   ]",
                "[ O |   | O ]",
                "[   | O |   | X ]",
                "[ O |   | O |   ]"
        );
    }

    @Test
    void printResult() {
        List<List<String>> sample = List.of(List.of(" O ", " O ", "   ", "   ", " O ", " O "),
                List.of("   ", "   ", " O ", " O ", "   ", "   "));

        List<List<StringBuilder>> elements = new ArrayList<>();
        sample.forEach(line -> elements.add(line.stream().map(e -> new StringBuilder(e)).collect(Collectors.toList())));

        outputView.printResult(elements, 7, true);
        Assertions.assertThat(outContent.toString()).contains(
                "최종 게임 결과",
                "[ O | O |   |   | O | O ]",
                "[   |   | O | O |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 7"
        );
    }
}