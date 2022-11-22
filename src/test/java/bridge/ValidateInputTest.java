package bridge;

import bridge.util.ValidateInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {

    @DisplayName("다리 길이가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void isNumber() {
        assertThatThrownBy(() -> ValidateInput.isNumber("11a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3~20의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void checkBridgeSizeRange() {
        assertThatThrownBy(() -> ValidateInput.checkBridgeSizeRange(2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ValidateInput.checkBridgeSizeRange(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 비어있는 경우 예외가 발생한다.")
    @Test
    void checkEmptyInput() {
        assertThatThrownBy(() -> ValidateInput.checkEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 U 또는 D가 아닌 경우 예외가 발생한다.")
    @Test
    void checkSpaceToMove() {
        assertThatThrownBy(() -> ValidateInput.checkSpaceToMove("A"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ValidateInput.checkSpaceToMove("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부 값이 R 또는 Q가 아닌 경우 예외가 발생한다.")
    @Test
    void checkGameRetry() {
        assertThatThrownBy(() -> ValidateInput.checkGameRetry("A"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ValidateInput.checkGameRetry("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

