package bridge;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    @Disabled
    @BeforeEach
    void makeBridge() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
    }

    @DisplayName("정상 이동 테스트")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"U, 1, 0, 0, 3", "D, 0, 1, 1, 3"})
    @Disabled
    void moveCorrectly(String expected, int p1, int p2, int p3, int size) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(p1, p2, p3));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
    }

    @Test
    @DisplayName("재시작 정상 입력 확인")
    void checkRetry() {
        BridgeGame bridgeGame = new BridgeGame(3);
        boolean actual = bridgeGame.retry("R");
        assertTrue(actual);
    }

    @Test
    @DisplayName("종료 정상 입력 확인")
    void checkQuit() {
        BridgeGame bridgeGame = new BridgeGame(3);
        boolean actual = bridgeGame.retry("Q");
        assertFalse(actual);
    }

    @DisplayName("재시작/종료 비정상 입력 확인")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"A", "d", "1", "하", "-"})
    void checkRetryOrQuit(String input) {
        BridgeGame bridgeGame = new BridgeGame(3);
        try {
            boolean actual = bridgeGame.retry(input);
        } catch (IllegalArgumentException e) {
            assertEquals(Error.R_OR_Q.toString(), e.getMessage());

        }
    }
}
