package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertEquals(3,bridgeMaker.makeBridge(3).size());
    }
}