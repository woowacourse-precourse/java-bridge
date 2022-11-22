package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
