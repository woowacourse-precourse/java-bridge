package bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    @DisplayName("이동 정상 입력 확인")
    @RepeatedTest(10)
    void checkUpOrDown() {
        BridgeGame bridgeGame = new BridgeGame(3);
        String value = bridgeGame.getValue(0);
        if (value.equals(Input.UP.toString())) {
            boolean actual = bridgeGame.move(Input.UP.toString(), 0);
            assertTrue(actual);
        }
        if (value.equals(Input.DOWN.toString())) {
            boolean actual = bridgeGame.move(Input.DOWN.toString(), 0);
            assertTrue(actual);
        }
    }

    @DisplayName("잘못된 이동 정상 입력 확인")
    @RepeatedTest(10)
    void checkWrongUpOrDown() {
        BridgeGame bridgeGame = new BridgeGame(3);
        String value = bridgeGame.getValue(0);
        if (value.equals(Input.UP.toString())) {
            boolean actual = bridgeGame.move(Input.DOWN.toString(), 0);
            assertFalse(actual);
        }
        if (value.equals(Input.DOWN.toString())) {
            boolean actual = bridgeGame.move(Input.UP.toString(), 0);
            assertFalse(actual);
        }
    }

    @DisplayName("이동 비정상 입력 확인")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"A", "d", "1", "하", "-"})
    void checkUpOrDownInput(String input) {
        BridgeGame bridgeGame = new BridgeGame(3);
        try {
            bridgeGame.move(input, 0);
        } catch (IllegalArgumentException e) {
            assertEquals(Error.U_OR_D.toString(), e.getMessage());
        }
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
            bridgeGame.retry(input);
        } catch (IllegalArgumentException e) {
            assertEquals(Error.R_OR_Q.toString(), e.getMessage());
        }
    }
}
