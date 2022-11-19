package bridge.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.validate.ValidateInput.validateBridgeSize;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @DisplayName("입력받은 다리 길이가 정수가 아니거나 입력받은 3이상 20이하의 수가 아니라면 예외가 발생한다.")
    @Test
    void 다리길이가_정수가_아니거나_3이상_20이하의_수가_아니면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            validateBridgeSize("10d");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            validateBridgeSize("21");
        });
    }

}