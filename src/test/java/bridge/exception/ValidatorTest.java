package bridge.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private final int INPUT_WRONG_BRIDGE_LENGTH = 5000;
    private final String INPUT_WRONG_MOVING = "E";

    @DisplayName("다리 길이는 3이상 20이하여야 합니다.")
    @Test
    void checkBridgeLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
           Validator.validBridgeLength(INPUT_WRONG_BRIDGE_LENGTH);
        });
        assertEquals(exception.getMessage(), Error.WRONG_BRIDGE_LENGTH.getMessage());
    }

    @DisplayName("이동할 수 있는 칸은 U(위)와 D(아래)여야 합니다.")
    @Test
    void validMoving() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validMoving(INPUT_WRONG_MOVING);
        });
        assertEquals(exception.getMessage(), Error.WRONG_MOVING.getMessage());
        System.out.println(Error.WRONG_MOVING.getMessage());
    }
}