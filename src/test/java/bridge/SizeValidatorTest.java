package bridge;

import bridge.view.SizeValidator;
import bridge.view.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SizeValidatorTest {

    @DisplayName("범위를 벗어난 입력")
    @Test
    void outOfRange() {
        Validator validator = new SizeValidator();
        String str = "333";
        String error = "범위";
        assertThatThrownBy(() -> validator.validate(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @DisplayName("숫자가 아닌 것을 입력")
    @Test
    void notNumber() {
        Validator validator = new SizeValidator();
        String str = "가나다";
        String error = "숫자를";
        assertThatThrownBy(() -> validator.validate(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }
}
