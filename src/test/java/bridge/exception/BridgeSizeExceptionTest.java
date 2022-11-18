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
}
