package bridge.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.validate.ValidateInput.validateBridgeSize;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @DisplayName("입력받은 다리 길이가 정수가 아니면 예외가 발생한다.")
    @Test
    void 다리길이가_정수가_아니라면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            validateBridgeSize("10d");
        });
    }
}