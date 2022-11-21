package bridge;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGameController;
import bridge.model.BridgeGame;
import bridge.model.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameFunctionTest {
    private BridgeMaker bridgeMaker;
    private Record record;

    @BeforeEach
    void initialize() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        record = new Record(new ArrayList<>(), new HashMap<>());
    }

    @Nested
    class MakeBridgeTest {
        @DisplayName("유효한 범위 내 숫자를 입력하면 해당 길이를 가진 다리를 생성한다.")
        @ValueSource(ints = {3, 10, 20})
        @ParameterizedTest
        void successGetBridge(int bridgeSize) {
            assertThat(bridgeMaker.makeBridge(bridgeSize))
                    .isInstanceOf(List.class);
        }

        @DisplayName("유효한 범위 밖의 숫자를 입력하면 오류가 발생한다.")
        @ValueSource(strings = {"-1", "100", "1000000000000000"})
        @ParameterizedTest
        void failGetBridge(String input) {
            BridgeGameController bridgeGameController = new BridgeGameController();
            assertThatThrownBy(() -> bridgeGameController.start(input, record))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class MoveTest {
        @DisplayName("유효한 형식의 방향을 입력하면 오류 없이 반환한다.")
        @ValueSource(strings = {"U", "D"})
        @ParameterizedTest
        void successMovingDirection(String moving) {
            BridgeGame bridgeGame = new BridgeGame();
            assertThatThrownBy(() ->
                    assertThatThrownBy(() -> bridgeGame.move(record, moving))
                    .isInstanceOf(IllegalArgumentException.class))
                    .isInstanceOf(AssertionError.class);  // 예외가 발생하지 않으므로 AssertionError 발생
        }

        @DisplayName("유효하지 않은 방향을 입력하면 오류가 발생한다.")
        @ValueSource(strings = {"u", "d", "KKK", "%%"})
        @ParameterizedTest
        void failMovingDirection(String moving) {
            BridgeGame bridgeGame = new BridgeGame();
            assertThatThrownBy(() -> bridgeGame.move(record, moving))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class RetryTest {
        @DisplayName("유효한 형식의 명령어를 입력하면 오류 없이 반환한다.")
        @ValueSource(strings = {"R", "Q"})
        @ParameterizedTest
        void successGetCommandDirection(String command) {
            BridgeGame bridgeGame = new BridgeGame();
            assertThatThrownBy(() -> assertThatThrownBy(
                    () -> bridgeGame.retry(record, command))
                    .isInstanceOf(IllegalArgumentException.class))
                    .isInstanceOf(AssertionError.class);  // 예외가 발생하지 않으므로 AssertionError 발생
        }

        @DisplayName("유효하지 않은 명령어를 입력하면 오류가 발생한다.")
        @ValueSource(strings = {"r", "q", "KKK", "%%"})
        @ParameterizedTest
        void failGetCommandDirection(String command) {
            BridgeGame bridgeGame = new BridgeGame();
            assertThatThrownBy(() -> bridgeGame.retry(record, command))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
