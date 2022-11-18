package bridge.model.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class BridgeSizeValidatorTest {
    @ParameterizedTest
    @DisplayName("잘못된 다리 사이즈를 입력 받으면 예외를 발생시킨다.")
    @CsvSource({
            "0",
            "2",
            "100",
            "1 2",
            "21",
            "ab",
            "5b"
    })
    void throwExceptionForInvalidBridgeSize(String input) {
        assertThatThrownBy(() -> new BridgeSizeValidator().validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 입력 받으면 예외를 발생시킨다.")
    void throwExceptionForEmpty() {
        assertThatThrownBy(() -> new BridgeSizeValidator().validateNumeric(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 입력 받으면 예외를 발생시킨다.")
    @CsvSource({
            "b",
            ",,",
            "12xc"
    })
    void throwExceptionForNonNumericInput(String input) {
        assertThatThrownBy(() -> new BridgeSizeValidator().validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("문자 길이가 2보다 긴 입력 받으면 예외를 발생시킨다.")
    @CsvSource({
            "bbb",
            "222",
            "0011"
    })
    void throwExceptionForWrongLengthInput(String input) {
        assertThatThrownBy(() -> new BridgeSizeValidator().validateLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
