package bridge.repository;

import static org.junit.jupiter.api.Assertions.*;

import bridge.exception.Error;
import org.junit.jupiter.api.Test;

class BridgeRepositoryTest {

    @Test()
    void 다리_길이_예외_테스트() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new BridgeRepository(5000);
        });
        assertEquals(exception.getMessage(), Error.WRONG_BRIDGE_LENGTH.getMessage());
    }
}