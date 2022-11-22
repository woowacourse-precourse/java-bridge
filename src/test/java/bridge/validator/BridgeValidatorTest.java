package bridge.validator;

import static bridge.validator.BridgeValidator.validateBridgeSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.WrongBridgeSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeValidatorTest {

    @DisplayName("다리의 길이는 3과 20사이 숫자이다.")
    @CsvSource(value = {"3:3", "5:5", "20:20"}, delimiter = ':')
    @ParameterizedTest
    void bridgeSizeIsBetween3And20(String input, int value) {
        validateBridgeSize(input);
        assertThat(Integer.parseInt(input)).isEqualTo(value);
    }

    @DisplayName("다리의 길이가 3미만 20초과인 경우 예외처리 한다.")
    @ValueSource(strings = {"1", "-1", "21", "0"})
    @ParameterizedTest
    void bridgeSizeNotLessThan3AndNotMoreThan20(String input) {
        assertThatThrownBy(() -> validateBridgeSize(input))
                .isInstanceOf(WrongBridgeSizeException.class);
    }


    @DisplayName("다리길이가 양의 정수가 아닐 경우 예외처리 한다.")
    @ValueSource(strings = {"3.5", "1.5", "abc", "3a", "-1"})
    @ParameterizedTest
    void bridgeSizeMustBePositiveInteger(String input) {
        assertThatThrownBy(() -> validateBridgeSize(input))
                .isInstanceOf(WrongBridgeSizeException.class);
    }

    @DisplayName("다리 길이가 1_000_000_000 이상일 때 예외처리 한다.")
    @ValueSource(strings = {"1000000000", "99999999999"})
    @ParameterizedTest
    void bridgeSizeNotTooBigInteger(String input) {
        assertThatThrownBy(() -> validateBridgeSize(input))
                .isInstanceOf(WrongBridgeSizeException.class);
    }
}