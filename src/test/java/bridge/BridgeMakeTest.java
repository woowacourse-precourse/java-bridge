package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeMakeTest {
    @Test
    void 다리_만들기_사이즈_3() {
        ArrayList<Integer> testBridge = new ArrayList<>(List.of(1, 0, 1));
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(testBridge);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> answerBridge = bridgeMaker.makeBridge(3);
        assertThat(answerBridge).containsExactly("U", "D", "U");
    }
    @Test
    void 다리_만들기_사이즈_10() {
        ArrayList<Integer> testBridge = new ArrayList<>(List.of(1,1,1,1,1,1,1,1,1,0));
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(testBridge);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> answerBridge = bridgeMaker.makeBridge(10);
        assertThat(answerBridge).containsExactly("U", "U", "U","U", "U", "U","U", "U", "U","D");
    }
    @Test
    void 다리_만들기_사이즈_20() {
        ArrayList<Integer> testBridge = new ArrayList<>(List.of(1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0));
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(testBridge);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> answerBridge = bridgeMaker.makeBridge(20);
        assertThat(answerBridge).containsExactly("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U","D");
    }
}
