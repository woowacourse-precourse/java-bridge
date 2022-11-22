package bridge;

import bridge.view.MoveValidator;
import bridge.view.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveValidatorTest {

    @DisplayName("잘못된 입력")
    @Test
    void wrongCase() {
        Validator validator = new MoveValidator();
        String str = "d";
        String error = "U 혹은 D";
        assertThatThrownBy(() -> validator.validate(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }
}
