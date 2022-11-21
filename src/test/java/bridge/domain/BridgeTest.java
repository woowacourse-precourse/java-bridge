package bridge.domain;

import bridge.exception.BridgeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    @Test
    void 다리길이_입력받기(){
        String good = "6";
        String notNumeric = "a";
        String notLengthRange = "30";

        Bridge.inputBridgeLength(good);
        assertThat(6).isEqualTo(Bridge.getBridgeLength());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> Bridge.inputBridgeLength(notNumeric));
        assertThat(exception.getMessage()).isEqualTo(BridgeException.NOT_NUMERIC.getErrorMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, ()-> Bridge.inputBridgeLength(notLengthRange));
        assertThat(exception1.getMessage()).isEqualTo(BridgeException.INVALID_LENGTH_RANGE.getErrorMessage());

    }
}