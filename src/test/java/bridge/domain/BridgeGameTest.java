package bridge.domain;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private final List<String> arr = new ArrayList<>(List.of("U", "D", "U"));

    @BeforeEach
    void setup() {
        bridgeGame = BridgeGame.from(Bridge.from(arr));
    }

    @DisplayName("잘못된 move 명령어를 입력하면 오류를 반환한다.")
    @ValueSource(strings = {"A", "s", "t"})
    @ParameterizedTest
    void throwErrorWhenInputInvalidMoveCommand(String command) {
        assertThatThrownBy(() -> bridgeGame.move(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 move 명령어를 입력한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void returnResultWhenInputValidMoveCommand(String command) {
        Assertions.assertThat(bridgeGame.move(command)).isInstanceOf(GameResult.class);
    }

    @DisplayName("재시도 요청을 한 경우 그에 맞는 상태 값을 반환한다.")
    @MethodSource("provideInputForRetry")
    @ParameterizedTest
    void returnMoveStatusWhenGiveCorrectRetryCommand(String command, ViewStatus status) {
        ViewStatus result = bridgeGame.retry(command);

        assertThat(result).isEqualTo(status);
    }

    @DisplayName("재시도 요청 중 잘못된 입력을 한 경우 오류 반환.")
    @ValueSource(strings = {"adf", "1", "A", "d"})
    @ParameterizedTest
    void throwErrorWhenInvalidRetryCommand(String command) {
        assertThatThrownBy(() -> bridgeGame.retry(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("retry 횟수만큼 반환한다.")
    @ValueSource(ints = {1, 2, 3, 4})
    @ParameterizedTest
    void returnRetryCount(int count) {
        retryMultipleTime(count);
        assertThat(bridgeGame.getGameCount()).isEqualTo(count + 1);
    }

    private void retryMultipleTime(int count) {
        for (int retryCount = 1; retryCount <= count; retryCount++) {
            bridgeGame.retry("R");
        }
    }

    private static Stream<Arguments> provideInputForRetry() { // argument source method
        return Stream.of(
                Arguments.of("Q", ViewStatus.LOSE),
                Arguments.of("R", ViewStatus.DETERMINE_MOVE)
        );
    }
}