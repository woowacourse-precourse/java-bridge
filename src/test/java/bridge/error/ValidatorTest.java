package bridge.error;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("다리 길이에 대한 예외 처리")
    @ValueSource(strings = {"1", "2", "21", "999", "aaa", "bridge!@#"})
    @ParameterizedTest
    void validateBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸에 대한 예외 처리")
    @ValueSource(strings = {"1", "0", "R", "Q", "@#$"})
    @ParameterizedTest
    void validateMoving(String move) {
        assertThatThrownBy(() -> Validator.validateMoving(move))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateGameCommand() {
    }
}