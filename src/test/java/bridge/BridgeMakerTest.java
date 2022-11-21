package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    @Test
    void TestMakeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list =bridgeMaker.makeBridge(3);

    }
}