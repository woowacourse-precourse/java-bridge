package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeSizeExceptionTest {

    UserException bridgeSizeException = new BridgeSizeException();

    @Test
    @DisplayName("숫자가 아닌 값을 입력하면 예외를 반환한다.")
    void isNotIntTest() {
        assertThrows(IllegalArgumentException.class, () -> bridgeSizeException.checkException("R"));
    }
}
