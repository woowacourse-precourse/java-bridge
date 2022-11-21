package bridge;

import bridge.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    @DisplayName("다리길이 올바른 입력")
    void correctBridgeSizeInput() {
        assertThatCode(() -> Validator.checkBridgeSize(10))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어 이동 시 올바른 입력")
    void correctMove() {
        assertThatCode(() -> Validator.checkMoveInput("U"))
                .doesNotThrowAnyException();

        assertThatCode(() -> Validator.checkMoveInput("D"))
                .doesNotThrowAnyException();

    }


}
