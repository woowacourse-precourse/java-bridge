package bridge.validator;

import bridge.common.SystemSet;
import bridge.provider.BridgeSizeProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeValidatorTest {

    @ParameterizedTest
    @DisplayName("숫자가 아니라면 예외가 발생한다.")
    @ValueSource(strings = {"3개", "!!", " ", "삼"})
    public void 숫자_입력_테스트(String input) {
        assertThatThrownBy(() -> BridgeSizeValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자가 범위를 벗어나면 예외가 발생한다.")
    @ValueSource(strings = {"255", "21", "1", "-2", "0"})
    public void 범위_확인_테스트(String input) {
        assertThatThrownBy(() -> BridgeSizeValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("올바른 형식을 입력받는다.")
    @ArgumentsSource(BridgeSizeProvider.class)
    public void 올바른_입력_테스트(String inputStr, int inputInt) {
        SystemSet.input(inputStr);

        Assertions.assertThat(BridgeSizeValidator.validate(inputStr)).isEqualTo(inputInt);
    }
}
