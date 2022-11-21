package bridge.util.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ViewValidatorTest {

    @DisplayName("입력 값이 양수가 아니면, 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1","가","A"})
    void isNumberErrorTest(String input) {
        assertThatThrownBy(()->ViewValidator.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
