package bridge.model;

import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init_Test() {
        bridgeGame = new BridgeGame(3, new BridgeStaticNumberGenerator());
    }

    
    private class BridgeStaticNumberGenerator implements BridgeNumberGenerator {
        int count = 0;

        @Override
        public int generate() {
            if (count++ % 2 == 0) {
                return 1;
            }
            return 0;
        }
    }
}