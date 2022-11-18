package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void makeBridge() {
        List<String> testBridge = bridgeMaker.makeBridge(30);
        Assertions.assertThat(testBridge.size()).isEqualTo(30);
        Assertions.assertThat(testBridge).containsOnly("U", "D");
    }
}