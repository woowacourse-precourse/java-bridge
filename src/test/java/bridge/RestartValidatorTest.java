package bridge;

import bridge.view.RestartValidator;
import bridge.view.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartValidatorTest {

    @DisplayName("잘못된 입력")
    @Test
    void wrongCase() {
        Validator validator = new RestartValidator();
        String str = "d";
        String error = "Q 혹은 R";
        assertThatThrownBy(() -> validator.validate(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }
}