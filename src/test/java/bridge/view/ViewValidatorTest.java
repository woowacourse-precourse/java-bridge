package bridge.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ViewValidatorTest {
    @DisplayName("비어있는 값을 입력했을 때 IllegalArgumentException 에러를 발생시킨다.")
    @Test
    void validateNumberInputWithEmptyValue() {
        String input = "";
        assertThatThrownBy(() -> ViewValidator.validateNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR]",
                        "값을 입력하지 않았습니다."
                );
    }

    @DisplayName("숫자가 아닌 값을 입력했을 때 IllegalArgumentException 에러를 발생시킨다.")
    @Test
    void validateNumberInputWithNonNumericValue() {
        String input = "1a";
        assertThatThrownBy(() -> ViewValidator.validateNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR]",
                        "숫자만 입력해주세요."
                );
    }

    @DisplayName("올바른 칸의 입력 (U, D)에 대해 에러를 발생시키지 않는다.")
    @ParameterizedTest(name = "{index}) Panel Input = {0}")
    @ValueSource(strings = { "U", "D" })
    void validatePanelInput(String input) {
        assertThatCode(() -> ViewValidator.validatePanelInput(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("움직일 칸의 입력으로 비어있는 값을 입력했을 때 IllegalArgumentException 에러를 발생시킨다.")
    @Test
    void validatePanelInputWithEmptyValue() {
        String input = "";
        assertThatThrownBy(() -> ViewValidator.validatePanelInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR]",
                        "값을 입력하지 않았습니다."
                );
    }

    @DisplayName("올바르지 않은 칸의 입력에 대해 IllegalArgumentException 에러를 발생시킨다.")
    @ParameterizedTest(name = "{index}) Panel Input = {0}")
    @ValueSource(strings = { "E", "R", "Q", "1", "u", "d" })
    void validatePanelInputWithInvalidValue(String input) {
        assertThatThrownBy(() -> ViewValidator.validatePanelInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR]",
                        "U(위), D(아래) 중 하나만 입력해주세요."
                );
    }

    @DisplayName("올바른 재시작 옵션의 입력 (R, Q)에 대해 에러를 발생시키지 않는다.")
    @ParameterizedTest(name = "{index}) Panel Input = {0}")
    @ValueSource(strings = { "R", "Q" })
    void When_InputValidRetryOption_Expect_NoException(String input) {
        assertThatCode(() -> ViewValidator.validateRetryOptionInput(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("올바르지 않은 재시작 옵션의 입력에 대해 IllegalArgumentException 에러를 발생시킨다.")
    @ParameterizedTest(name = "{index}) Panel Input = {0}")
    @ValueSource(strings = { "E", "U", "D", "1", "r", "q" })
    void When_InputInvalidRetryOption_Expect_IllegalArgumentException(String input) {
        assertThatThrownBy(() -> ViewValidator.validateRetryOptionInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR]",
                        "R(재시작), Q(종료) 중 하나만 입력해주세요."
                );
    }
}
