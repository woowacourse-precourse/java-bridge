package bridge;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExceptionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 21, 23, 50, 100})
    void bridgeSizeExceptionTest(int size) {
        assertThrows(IllegalArgumentException.class, () -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeMaker.makeBridge(size);
        });
    }


}