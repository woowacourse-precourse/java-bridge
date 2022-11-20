package bridge;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    private static final String EXCEPTION_MESSAGE_INVALID_MOVE = "[ERROR] 이동 가능 칸은 U 또는 D 만 있습니다.";
    private static final String EXCEPTION_MESSAGE_INVALID_RETRY = "[ERROR] 재시도 여부는 R 또는 Q 만 입력해야 됩니다.";
    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(
                newArrayList(1, 1, 0, 1, 1, 0, 1, 1, 0, 1
                        , 1, 0, 1, 1, 0, 1, 1, 0, 1, 1));
        bridgeGame.makeBridge(20, numberGenerator);
    }

    @DisplayName("move 함수가 잘못된 값이 들어올시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "UP", "DOWN", "C", "E", "T", "V"})
    void moveByInvalidValue(String input) {
        assertThatThrownBy(() -> bridgeGame.move(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_INVALID_MOVE);
    }

    @DisplayName("move 함수가 정상적으로 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({"U, U, D, U, U, D"})
    void executeMoveToTrue(String input1, String input2, String input3,
                           String input4, String input5, String input6) {
        assertThat(true).isEqualTo(bridgeGame.move(input1));
        assertThat(true).isEqualTo(bridgeGame.move(input2));
        assertThat(true).isEqualTo(bridgeGame.move(input3));
        assertThat(true).isEqualTo(bridgeGame.move(input4));
        assertThat(true).isEqualTo(bridgeGame.move(input5));
        assertThat(true).isEqualTo(bridgeGame.move(input6));
    }

    @DisplayName("move 함수가 정상적으로 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"D, D, U, D, D, U"})
    void executeMoveToFalse(String input1, String input2, String input3,
                            String input4, String input5, String input6) {
        assertThat(false).isEqualTo(bridgeGame.move(input1));
        assertThat(false).isEqualTo(bridgeGame.move(input2));
        assertThat(false).isEqualTo(bridgeGame.move(input3));
        assertThat(false).isEqualTo(bridgeGame.move(input4));
        assertThat(false).isEqualTo(bridgeGame.move(input5));
        assertThat(false).isEqualTo(bridgeGame.move(input6));
    }

    @DisplayName("retry 함수가 잘못된 값이 들어올시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "Re", "Qt", "U", "D", "P", "S", "\n", " "})
    void retryByInvalidValue(String input) {
        assertThatThrownBy(() -> bridgeGame.retry(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_INVALID_RETRY);
    }

    @DisplayName("retry 함수가 정상적으로 true를 반환한다.")
    @Test
    void executeRetryToTrue() {
        assertThat(true).isEqualTo(bridgeGame.retry("R"));
    }

    @DisplayName("retry 함수가 정상적으로 false를 반환한다.")
    @Test
    void executeRetryToFalse() {
        assertThat(false).isEqualTo(bridgeGame.retry("Q"));
    }
}
