package bridge;

import bridge.exception.LengthOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeLengthValidatorTest {
    @ParameterizedTest(name = "{index}: {displayName} length:{0}")
    @DisplayName("옳바른 다리 길이 입력 시")
    @ValueSource(ints = {3, 5, 20})
    void inputValidBridgeLength(int length) {
        assertDoesNotThrow(() -> BridgeValidator.validateLength(length));
    }

    @ParameterizedTest(name = "{index}: {displayName} length:{0}")
    @DisplayName("범위를 벗어난 다리 길이 입력 시 예외 발생")
    @ValueSource(ints = {-1, 2, 21})
    void inputOutOfRangeBridgeLength(int length) {
        assertThrows(LengthOutOfRangeException.class, () -> BridgeValidator.validateLength(length));
    }
}
