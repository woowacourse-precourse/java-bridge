package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "20"})
    @DisplayName("입력값이 숫자일 때 true 를 반환하는지 확인한다.")
    void validateNumber(String input) {
        Assertions.assertThat(StringUtil.isNumber(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABC", "가나다"})
    @DisplayName("입력값이 숫자가 아닐 때 false 를 반환하는지 확인한다.")
    void validateNumberByInvalidInput(String input) {
        Assertions.assertThat(StringUtil.isNumber(input)).isEqualTo(false);
    }
}