package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeExceptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"가나다라", "test", "20가", "!@#", "_+1"})
    void bridgeSizeNotNumeric(String bridgeSize) {
        assertThatThrownBy(() -> BridgeSizeException.validate(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21", "23"})
    void bridgeSizeWrongRange(String bridgeSize) {
        assertThatThrownBy(() -> BridgeSizeException.validate(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
