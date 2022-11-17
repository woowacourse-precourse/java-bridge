package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidateTest {
    @DisplayName("숫자로 변환할 수 있는 문자열인지")
    @ParameterizedTest
    @ValueSource(strings = {"15A"})
     void inputNotNumber(String input) {
        Assertions.assertThatThrownBy(() -> InputValidate.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("실수가 아닌 정수인지")
    @ParameterizedTest
    @ValueSource(strings = {"3.4"})
    void inputNotInteger(String input) {
        Assertions.assertThatThrownBy(() -> InputValidate.isInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("다리의 길이가 될 수 있는 수인지")
    @ParameterizedTest
    @ValueSource(ints = {21})
    void inputImpossibleSize(int input) {
        Assertions.assertThatThrownBy(() -> InputValidate.possibleBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
