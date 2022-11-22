package bridge;

import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void makeBridgeTest_1() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker testBridgeMaker = new BridgeMaker(numberGenerator);
        List<String> testBridge = testBridgeMaker.makeBridge(3);
        assertThat(testBridge).containsExactly("U", "D", "D");
    }

    @Test
    void makeBridgeTest_2() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 0, 0, 1, 0, 1));
        BridgeMaker testBridgeMaker = new BridgeMaker(numberGenerator);
        List<String> testBridge = testBridgeMaker.makeBridge(6);
        assertThat(testBridge).containsExactly("D", "D", "D", "U", "D", "U");
    }

}