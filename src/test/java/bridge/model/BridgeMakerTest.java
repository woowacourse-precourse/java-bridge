package bridge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @DisplayName("Test whether user can make a proper size bridge")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 10})
    void makeBridge(int input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertEquals(input, bridgeMaker.makeBridge(input).size());
    }

}
