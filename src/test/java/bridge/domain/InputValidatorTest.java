package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputBridgeSizeNotNumber() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 숫자만 입력해야 합니다.");
    }

    @DisplayName("입력값이 3 에서 20 사이가 아닌 경우 예외가 발생한다.")
    @Test
    void inputBridgeSizeNotInRange() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 다리 길이는 3 에서 20 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("2"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 다리 길이는 3 에서 20 사이의 숫자여야 합니다.");

    }

    @DisplayName("입력값이 3-20 사이의 숫자인 경우 예외가 발생하지 않는다")
    @Test
    void inputBridgeSizeAppropriate() {
        assertThatNoException().isThrownBy(() -> inputValidator.validateBridgeSize("10"));
    }

    @DisplayName("입력값이 U, D 중 하나가 아닌 경우 예외가 발생한다")
    @Test
    void inputMovingNotMove() {
        assertThatThrownBy(() -> inputValidator.validateMoving("a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] U, D 중 하나를 입력해야 합니다.");
    }

    @DisplayName("입력값이 U, D 중 하나인 경우 예외가 발생하지 않는다")
    @Test
    void inputMovingAppropriate() {
        assertThatNoException().isThrownBy(() -> inputValidator.validateMoving("U"));
        assertThatNoException().isThrownBy(() -> inputValidator.validateMoving("D"));
    }

}
