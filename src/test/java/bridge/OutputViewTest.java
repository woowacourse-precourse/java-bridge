package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    static Stream<Arguments> generateOutputs() {
        return Stream.of(
                Arguments.of(
                        List.of("1", "[ O | O |   ]" + "\n" + "[   |   | O ]",
                                "성공"),
                        List.of("2", "[ O | O |   ]" + "\n" + "[   |   | O ]",
                                "성공"),
                        List.of("1", "[ O | O | X ]" + "\n" + "[   |   |   ]",
                                "실패"),
                        List.of("2", "[   ]" + "\n" + "[ X ]",
                                "실패"))
        );
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "' O | O |   ','   |   | O '",
            "' O | O | X ','   |   |   '"
    })
    void printMap_Check(StringBuilder up, StringBuilder down) {
        outputView.printMap(up, down);
        assertThat(outputStreamCaptor.toString()).contains("[" + up + "]", "[" + down + "]");
    }

    @ParameterizedTest
    @MethodSource("generateOutputs")
    void printResult_Check(List<String> outputs) {
        outputView.printResult(outputs);
        assertThat(outputStreamCaptor.toString()).contains(
                outputs.get(0), outputs.get(1), outputs.get(2)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "' O | O |   ','   |   | O '",
            "' O | O | X ','   |   |   '"
    })
    void castMap_Check(StringBuilder up, StringBuilder down) {
        assertThat(outputView.castMap(up, down))
                .isEqualTo("[" + up + "]" + "\n" + "[" + down + "]");
    }

    @Test
    void castSuccess() {
        assertThat(outputView.castSuccess(true)).isEqualTo("성공");
        assertThat(outputView.castSuccess(false)).isEqualTo("실패");
    }

    @Test
    void printStart() {
        outputView.printStart();
        assertThat(outputStreamCaptor.toString())
                .contains("다리 건너기 게임을 시작합니다.");
    }
}