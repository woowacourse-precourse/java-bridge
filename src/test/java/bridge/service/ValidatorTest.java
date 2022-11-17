package bridge.service;

import bridge.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Nested
    class ValidateBridgeLength {

        @ParameterizedTest
        @ValueSource(strings = {"십일", "3.14", "-10", "3.0"})
        @DisplayName("다리 길이 입력값이 양의 정수가 아닌 경우 예외를 던진다.")
        void isNotPositiveNumber(String bridgeLength) {
            Assertions.assertThatThrownBy(() -> validator.validateBridgeLength(bridgeLength))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.IS_NOT_POSITIVE_NUMBER.message());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "21", "22", "23"})
        @DisplayName("다리 길이 입력값이 범위(3 ~ 20)를 벗어난 경우 예외를 던진다.")
        void outOfRange(String bridgeLength) {
            Assertions.assertThatThrownBy(() -> validator.validateBridgeLength(bridgeLength))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.IS_OUT_OF_RANGE.message());
        }
    }
}