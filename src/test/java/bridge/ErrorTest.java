package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ErrorTest {
    @DisplayName("숫자를 입력하지 않은 경우 예외 발생")
    @Test
    void validateNumber() {
        Assertions.assertThatThrownBy(() -> Error.validateNumber("가"))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 범위를 벗어난 경우 예외 발생")
    @Test
    void validateNumberRange() {
        Assertions.assertThatThrownBy(() -> Error.validateNumberRange(3, 20, 22))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지정된 선택지 외 예외 발생 - 다리 선택")
    @Test
    void validateBridgeAnswer() {
        Assertions.assertThatThrownBy(() -> Error.validateBridgeAnswer("가"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지정된 선택지 외 예외 발생 - 재시작 선택")
    @Test
    void validateCommend() {
        Assertions.assertThatThrownBy(() -> Error.validateCommend("가"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}