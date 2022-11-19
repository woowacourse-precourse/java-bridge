package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
