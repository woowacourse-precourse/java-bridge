package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @DisplayName("다리 크기 범위 밖의 입력에 대한 예외 처리")
    @ValueSource(strings = {"99999999999", "-1", "0", "-1000000000000000000"})
    @ParameterizedTest
    void invalidBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("moving 이 U 또는 D 가 아닌 경우 예외 처리")
    @ValueSource(strings = {"A", "UD", "123", "abcdefghijk"})
    @ParameterizedTest
    void invalidMoving(String moving) {
        assertThatThrownBy(() -> Validator.validateMoving(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("gameCommand 가 R 또는 Q 가 아닌 경우 예외 처리")
    @ValueSource(strings = {"U", "D", "1234", "qwerty"})
    @ParameterizedTest
    void invalidGameCommand(String gameCommand) {
        assertThatThrownBy(() -> Validator.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
