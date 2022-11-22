package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {

    @DisplayName("입력값이 숫자가 아닌 경우 예외 테스트")
    @ValueSource(strings = {"a", "10a", " ", "@@"})
    @ParameterizedTest
    void notNumberTest(String size) {
        assertThatThrownBy(() -> InputValidation.convertToInt(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리길이가 범위 밖일 경우 예외 테스트")
    @ValueSource(ints = {1, 2, 21, 300})
    @ParameterizedTest
    void inputBridgeRangeTest(int size) {
        assertThatThrownBy(() -> InputValidation.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U 혹은 D가 아닌 입력값일 시 예외 메시지 테스트")
    @ValueSource(strings = {"u", "r", "3"})
    @ParameterizedTest
    void upOrDownCommandTest(String upOrDown) {
        assertThatThrownBy(() -> InputValidation.validateUpDown(upOrDown))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]U 또는 D만 입력 가능합니다.(위: U, 아래: D)");
    }
}