package bridge;

import bridge.domain.user.UserMaker;
import bridge.domain.user.User;
import bridge.domain.ui.OutputView;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    private static final OutputView outputView = new OutputView();
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final UserMaker USER_MAKER = new UserMaker();
    private static User testUserStatus;

    @BeforeAll
    static void setTest() {
        System.setOut(new PrintStream(output));
        List<String> answerBridge = new ArrayList<>(List.of("U", "D", "U", "D"));
        int bridgeSize = answerBridge.size();
        testUserStatus = USER_MAKER.makeUser(bridgeSize);
    }

    @AfterAll
    static void testResult() {
        String expected = "\n최종 게임 결과\n" +
                "[ O |   | O |   ]\n[   | O |   | X ]" +
                "\n\n게임 성공 여부: " +
                "실패" +
                "\n총 시도한 횟수: 1";

        outputView.printResult(testUserStatus);
        assertThat(output.toString()).isEqualTo(expected);
    }

    @DisplayName("게임이 실패한 경우")
    @ParameterizedTest
    @CsvSource({"1, 1, O", "0, 2, O", "1, 3, O", "0, 4, X"})
    void failedGameTest(int selectedSpaceIdx, int currBridgeOrder, String movingResult) {
        testUserStatus.addCrossingResult(selectedSpaceIdx, currBridgeOrder, movingResult);
    }
}
