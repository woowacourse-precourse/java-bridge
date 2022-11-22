package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private final Validator validator = new Validator();

    @DisplayName("숫자로 이루어진 값이 아니면 예외가 발생한다.")
    @Test
    void validateBridgeSizeExceptionTest() {
        assertThatThrownBy(() -> validator.validateBridgeSize("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3~20 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateBridgeSizeTest() {
        assertThatThrownBy(() -> validator.validateBridgeSize("230"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("\"U\" 또는 \"D\" 가 아니면 예외가 발생한다.")
    @Test
    void validateMoving() {
        assertThatThrownBy(() -> validator.validateMoving("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("\"R\" 또는 \"Q\"가 아니면 예외가 발생한다.")
    @Test
    void validateGameCommand() {
        assertThatThrownBy(() -> validator.validateMoving("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}