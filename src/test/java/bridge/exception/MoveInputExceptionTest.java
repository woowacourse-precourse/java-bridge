package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveInputExceptionTest {

    private MoveInputException moveInputException = new MoveInputException();

    @Test
    @DisplayName("이동 입력은 U, D로만 이루어져야 한다.")
    void moveInputConsistOfUD() {
        assertThatThrownBy(() -> moveInputException.inputOnlyConsistOfUD("K")).isInstanceOf(
                IllegalArgumentException.class);
    }

}