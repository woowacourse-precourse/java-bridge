package bridge.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private final int WRONG_BRIDGE_LENGTH = 5000;
    private final String WRONG_BRIDGE_SPACE_TYPE = "E";

    @DisplayName("다리 길이는 3이상 20이하여야 합니다.")
    @Test
    void checkBridgeLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
           Validator.validBridgeLength(WRONG_BRIDGE_LENGTH);
        });
        assertEquals(exception.getMessage(), Error.WRONG_BRIDGE_LENGTH.getMessage());
    }

    @DisplayName("이동할 수 있는 칸은 U(위)와 D(아래)여야 합니다.")
    @Test
    void validBridgeSpaceType() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validBridgeSpaceType(WRONG_BRIDGE_SPACE_TYPE);
        });
        assertEquals(exception.getMessage(), Error.WRONG_BRIDGE_SPACE_TYPE.getMessage());
        System.out.println(Error.WRONG_BRIDGE_SPACE_TYPE.getMessage());
    }
}