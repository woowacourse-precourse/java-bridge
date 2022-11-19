package bridge;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static bridge.Space.*;
import static org.assertj.core.api.Assertions.*;

public class SetBridgeStatusTest {
    private final BridgeGame bridgeGame = new BridgeGame();
    private static final OutputView outputView = new OutputView();
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static UsersBridgeCrossStatus testBridge;
    private static String userInput;
    private static List<String> testAnswerBridge;

    @BeforeAll
    static void setTest() {
        System.setOut(new PrintStream(output));
        userInput = "D";
        testAnswerBridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        BridgeMakerImpl bridgeMakerImpl = new BridgeMakerImpl();
        testBridge = bridgeMakerImpl.makeInitialBridge(3);
    }

    @AfterAll
    static void assertions() {
        List<String> up = testBridge.getCurrentBridge().get(UP.getIndex());
        List<String> down = testBridge.getCurrentBridge().get(DOWN.getIndex());

        assertThat(up).isEqualTo(List.of("[", " ", "O", " ", "|", " ", " ", " ", "|", " ", " ", " ", "]"));
        assertThat(down).isEqualTo(List.of("[", " ", " ", " ", "|", " ", "O", " ", "|", " ", "X", " ", "]"));
        outputView.printMap(testBridge);
        assertThat(output.toString()).isEqualTo("[ O |   |   ]\n[   | O | X ]");

        testBridge.resetCurrentBridge();
        assertThat(testBridge.getCurrentBridge()).isEmpty();
    }

    @DisplayName("사용자가 선택한 칸이 이동 가능한 칸이면 O, 불가능한 칸이면 X를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1, X", "2, O", "3, X", "4, O"})
    void checkCrossabilityTest(int currBridgeOrder, String expectedResult) {
        String actualResult = bridgeGame.move(currBridgeOrder, testAnswerBridge, userInput);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("이동 결과를 UsersBridgeCrossStatus 내의 currentBridge에 저장한다.")
    @ParameterizedTest
    @MethodSource("sourceMethod")
    void addCrossingResultTest(Space selectedSpace, int currBridgeOrder, String movingResult) {
        testBridge.addCrossingResult(selectedSpace, currBridgeOrder, movingResult);
    }

    private static Stream<Arguments> sourceMethod() {
        return Stream.of(
                Arguments.of(UP, 1, "O"),
                Arguments.of(DOWN, 2, "O"),
                Arguments.of(DOWN, 3, "X")
        );
    }

}
