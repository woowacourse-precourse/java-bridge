package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputBridgeGameValidatorTest {

    @DisplayName("숫자가 아닐 경우")
    @Test
    void isDigitBridgeSize() {
        String bridgeSize = "a";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(() -> new InputBridgeGameValidator().validateBridgeSize(bridgeSize));
    }

    @DisplayName("빈 문자열을 입력할 경우 예외 처리")
    @Test
    void isEmptyBridgeSize() {
        String bridgeSize = "";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(() -> new InputBridgeGameValidator().validateBridgeSize(bridgeSize));
    }

    @DisplayName("3 이상 20 이하의 숫자가 아닐 경우 예외 처리")
    @Test
    void checkRangeBridgeSize() {
        String bridgeSize = "2";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(() -> new InputBridgeGameValidator().validateBridgeSize(bridgeSize));
    }
}