package bridge.view.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.view.Message.ERROR_NOT_DIGIT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.*;

class BridgeValidationTest {

    @ParameterizedTest
    @DisplayName("숫자가 아닌 경우 예외를 발생시킨")
    @CsvSource({
            "aa",
            "1a"
    })
    void isDigit(String input) {
        assertThatThrownBy(() -> new BridgeValidation().bridgeValidation(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @DisplayName("잘못된 다리 사이즈를 입력 받으면 예외를 발생시킨다.")
    @CsvSource({
            "aa",
            "1a"
    })
    void isInRange(String input) {
        assertThatThrownBy(() -> new BridgeValidation().bridgeValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}