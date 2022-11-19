package bridge.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @ParameterizedTest(name = "이동할 칸이 {0}이면 예외 던진다.")
    @ValueSource(strings = {"u", "d", "UD", "DU", " U", "D ", " ", ""})
    void 이동할_칸_형식_예외_던지는_기능(String moving) {
        assertThatThrownBy(() -> {
            InputValidator.validateMoving(moving);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "이동할 칸은 {0}의 형식이다.")
    @ValueSource(strings = {"U", "D"})
    void 이동할_칸_형식_U_D는_받아들이는_기능(String moving) {
        assertThatNoException().isThrownBy(() -> {
            InputValidator.validateMoving(moving);
        });
    }
}