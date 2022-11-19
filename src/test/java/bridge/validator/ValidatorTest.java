package bridge.validator;

import bridge.exception.ExceptionType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @DisplayName("다리길이 입력시 숫자가 아닌 경우 실패")
    @Test
    void 다리_길이_입력에_대한_타입_검증_테스트() {
        String errorMessage = ExceptionType.INTEGER_TYPE_EXCEPTION.getErrorMessage();
        String bridgeSizeInput = "a";
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSizeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("다리길이 입력시 3보다 작거나 20보다 클 경우 숫자 입력시 예외 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21", "22", "23"})
    void 다리_길이_입력에_대한_범위_검증_테스트_실패(String bridgeSize) {
        String errorMessage = ExceptionType.BRIDGE_RANGE_EXCEPTION.getErrorMessage();
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("다리 길이 입력 경계 값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3","20"})
    void 다리_길이_입력에_대한_범위_검증_테스트_성공(String bridgeSize) {
        assertThat(Validator.validateBridgeSize(bridgeSize))
                .isEqualTo(Integer.parseInt(bridgeSize));
    }
}
