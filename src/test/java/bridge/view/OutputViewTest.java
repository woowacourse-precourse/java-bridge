package bridge.view;

import bridge.domain.Bridge;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private OutputView outputView = new OutputView();

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("출력 확인 테스트 - 도중 틀렸을 경우")
    @Test
    void givenBridgeAndUserAnswer_whenPrintMap_thenPrintPartialBridgePattern() {
        //Given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D"));  // size : 12
        List<String> userAnswer = List.of("U", "D", "U", "U");

        //When
        outputView.printMap(bridge, userAnswer);

        //Then
        assertThat(output.toString()).contains(
                "[ O |   | O | X ]",
                "[   | O |   |   ]");
    }

    @DisplayName("출력 확인 테스트 - 전체 다 맞았을 경우")
    @Test
    void givenBridgeAndUserAnswer_whenPrintMap_thenPrintTotalBridgePattern() {
        //Given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D"));  // size : 12
        List<String> userAnswer = List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D");

        //When
        outputView.printMap(bridge, userAnswer);

        //Then
        assertThat(output.toString()).contains(
                "[ O |   | O |   | O |   | O |   | O |   | O |   ]",
                "[   | O |   | O |   | O |   | O |   | O |   | O ]"
        );
    }
}
