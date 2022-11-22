package bridge;

import org.junit.jupiter.api.Test;

import static bridge.validate.ValidateBridge.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateBridgeTest {

    @Test
    void 다리길이가_3이상_20이하가_아니면_예외() {
        int size1 = 2;
        int size2 = 21;
        assertThatThrownBy(() -> validateBridgeSizeInRange(size1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateBridgeSizeInRange(size2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리길이가_숫자가_아니면_예외() {
        String size = "s";
        assertThatThrownBy(() -> validateBridgeInteger(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동할_칸이_U나_D가_아니면_예외() {
        String move = "E";
        assertThatThrownBy(() -> validateMovement(move))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void retry_command가_R이나_Q가_아니면_예외() {
        String retry = "C";
        assertThatThrownBy(() -> validateMovement(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }

}