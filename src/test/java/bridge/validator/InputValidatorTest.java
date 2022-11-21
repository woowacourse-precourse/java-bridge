package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @DisplayName("입력이 정수이면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "-1", "1000000", "0"})
    void validInputIsNumber(String number) {
        assertThat(InputValidator.IS_NUMBER.test(number)).isTrue();
    }

    @DisplayName("입력이 정수가 아니라면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1e", "1.01", "string", "%"})
    void inValidInputNumber(String notNumber) {
        assertThat(InputValidator.IS_NUMBER.test(notNumber)).isFalse();
    }
    
}
