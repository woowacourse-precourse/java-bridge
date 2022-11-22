package bridge;

import bridge.domain.user.UserMaker;
import bridge.domain.user.User;
import bridge.domain.utils.BridgeGame;
import bridge.domain.ui.OutputView;
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

import static bridge.domain.utils.Space.*;
import static org.assertj.core.api.Assertions.*;

public class SetBridgeStatusTest {
    private static BridgeGame bridgeGame;
    private static final OutputView outputView = new OutputView();
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static User testBridge;
    private static String userInput;
    private static List<String> testAnswerBridge;

    @BeforeAll
    static void setTest() {
        System.setOut(new PrintStream(output));
        userInput = "D";
        testAnswerBridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        UserMaker userMaker = new UserMaker();
        testBridge = userMaker.makeUser(3);
        bridgeGame = new BridgeGame(testBridge, testAnswerBridge);
    }

    @AfterAll
    static void assertions() {
        List<String> up = testBridge.getCurrentBridge().get(UP.getIndex());
        List<String> down = testBridge.getCurrentBridge().get(DOWN.getIndex());

        assertThat(up).isEqualTo(List.of("[", " ", "O", " ", "|", " ", " ", " ", "|", " ", " ", " ", "]"));
        assertThat(down).isEqualTo(List.of("[", " ", " ", " ", "|", " ", "O", " ", "|", " ", "X", " ", "]"));
        outputView.printMap(testBridge);
        assertThat(output.toString()).isEqualTo("[ O |   |   ]\n[   | O | X ]\n\n");

        testBridge.resetCurrentBridge();
        assertThat(testBridge.getCurrentBridge().get(UP.getIndex())).isEqualTo(List.of("[", "]"));
        assertThat(testBridge.getCurrentBridge().get(DOWN.getIndex())).isEqualTo(List.of("[", "]"));
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
    void addCrossingResultTest(int selectedSpaceIdx, int currBridgeOrder, String movingResult) {
        testBridge.addCrossingResult(selectedSpaceIdx, currBridgeOrder, movingResult);
    }

    private static Stream<Arguments> sourceMethod() {
        return Stream.of(
                Arguments.of(1, 1, "O"),
                Arguments.of(0, 2, "O"),
                Arguments.of(0, 3, "X")
        );
    }

}
