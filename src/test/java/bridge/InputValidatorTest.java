package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("다리 길이 숫자외 입력 예외처리")
    void bridgeLengthType() {
        assertThatThrownBy(() -> inputValidator.checkBridgeInput("e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 길이가 3~20 사이가 아닐 때 예외처리")
    void bridgeLengthBoundary() {
        assertThatThrownBy(() -> inputValidator.checkBridgeInput("30"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 길이 올바른 입력 테스트")
    void bridgeLengthInputTest() {
        assertThatCode(() -> inputValidator.checkBridgeInput("10"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어 이동 U 또는 D외의 입력시 예외처리")
    void movementInputException() {
        assertThatThrownBy(() -> inputValidator.checkMovement("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어 이동 올바른 입력 테스트")
    void movementInputTest() {
        assertThatCode(() -> inputValidator.checkMovement("U"))
                .doesNotThrowAnyException();

        assertThatCode(() -> inputValidator.checkMovement("D"))
                .doesNotThrowAnyException();
    }

}
