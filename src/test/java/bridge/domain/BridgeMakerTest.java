package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    final static BridgeRandomNumberGenerator brg = new BridgeRandomNumberGenerator();
    final static BridgeMaker bm = new BridgeMaker(brg);
    final static Set<String> validate = Set.of("U", "D");

    @ParameterizedTest
    @DisplayName("makeBridge 테스트")
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void makeBridge(final int size) {
        List<String> tmp = bm.makeBridge(size);
        assertAll(
                () -> assertTrue(validate.containsAll(tmp)),
                () -> assertEquals(tmp.size(), size)
        );
    }
}