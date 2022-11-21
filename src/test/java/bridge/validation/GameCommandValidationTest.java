package bridge.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandValidationTest {

    @DisplayName("Q또는 R 이외의 값을 입력하면 예외처리")
    @Test
    void validateWhenInputOtherThanQAndR() {
        GameCommandValidation gameCommandValidation = new GameCommandValidation();

        assertThatThrownBy(() -> gameCommandValidation.validate("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}