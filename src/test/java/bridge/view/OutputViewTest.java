package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class OutputViewTest{

    OutputView outputView = new OutputView();

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
        outputView.printMap(List.of("D", "D", "U", "D", "U", "U"));
        Assertions.assertThat(outContent.toString()).contains(
                "[   |   | O |   | O | O ]",
                "[ O | O |   | O |   |   ]"
        );
    }

    @Test
    void printResult(){
        outputView.printResult(List.of("U", "U", "D", "D", "U", "U"), 7, true);
        Assertions.assertThat(outContent.toString()).contains(
                "최종 게임 결과",
                "[ O | O |   |   | O | O ]",
                "[   |   | O | O |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 7"
        );
    }
}