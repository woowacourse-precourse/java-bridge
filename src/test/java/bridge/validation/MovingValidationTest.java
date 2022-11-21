package bridge.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingValidationTest {

    @DisplayName("U또는 D 이외의 값을 입력하면 예외처리")
    @Test
    void validate() {
        MovingValidation movingValidation = new MovingValidation();

        assertThatThrownBy(()-> movingValidation.validate("u"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}