package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @ParameterizedTest
    @ValueSource(ints = {3,20})
    public void bridgeSizeAllowTest(int size) throws Exception {
        assertDoesNotThrow(() -> Bridge.from(size));
    }

    @ParameterizedTest
    @ValueSource(ints = {2,21})
    public void bridgeSizeExceptionTest(int size) throws Exception {
        assertThatThrownBy(() -> Bridge.from(size))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
