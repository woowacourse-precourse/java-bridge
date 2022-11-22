package bridge.service;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeServiceTest {

    private final BridgeService bridgeService = new BridgeService();

    @DisplayName("size 입력값이 범위를 초과한 경우 오류를 반환한다.")
    @ValueSource(ints = {21, 40, -1})
    @ParameterizedTest
    void throwErrorWhenSizeIsInvalid(int size) {
        assertThatThrownBy(() ->
                bridgeService.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("size 입력값이 범위 이내이면 적절한 상태값을 반환한다.")
    @ValueSource(ints = {20, 3, 5})
    @ParameterizedTest
    void returnMakeBridgeResponseWhenSizeIsInvalid(int size) {
        assertThat(bridgeService.makeBridge(size))
                .isEqualTo(ViewStatus.DETERMINE_MOVE);
    }

    @DisplayName("move 명령어 입력 값이 잘못된 경우 오류를 반환한다.")
    @ValueSource(strings = {"a", "t", "1"})
    @ParameterizedTest
    void throwErrorWhenInputIsWrong(String command) {
        bridgeService.makeBridge(3);

        assertThatThrownBy(() -> bridgeService.move(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("move 명령어 입력이 적절한 경우 그에 맞는 결과값을 반환한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void returnResultWhenInputIsValid(String command) {
        bridgeService.makeBridge(3);

        assertThat(bridgeService.move(command))
                .isInstanceOf(GameResult.class);
    }

    @DisplayName("retry 명령어 입력이 적절한 경우 그에 맞는 결과값을 반환한다.")
    @MethodSource("provideForValidRetry")
    @ParameterizedTest
    void returnResultWhenRetryInputIsValid(String command, ViewStatus status) {
        bridgeService.makeBridge(3);

        assertThat(bridgeService.retry(command))
                .isEqualTo(status);
    }

    @DisplayName("retry 명령어 입력이 부적절한 경우 에러를 반환한다.")
    @ValueSource(strings = {"da", "aah", "q", "r"})
    @ParameterizedTest
    void throwErrorWhenRetryInputIsInValid(String command) {
        bridgeService.makeBridge(3);

        assertThatThrownBy(() -> bridgeService.retry(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideForValidRetry() { // argument source method
        return Stream.of(
                Arguments.of("Q", ViewStatus.LOSE),
                Arguments.of("R", ViewStatus.DETERMINE_MOVE)
        );
    }
}