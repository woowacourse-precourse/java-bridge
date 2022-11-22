package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest
    @ValueSource(ints = {3, 14, 20})
    void validLengthOfBridgeTest(int lengthOfBridge) {
        List<String> bridge = bridgeMaker.makeBridge(lengthOfBridge);
        assertThat(bridge).hasSize(lengthOfBridge);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 14, 20})
    void bridgeWithOnlyUAndDTest(int sizeOfBridge) {
        List<String> bridge = bridgeMaker.makeBridge(sizeOfBridge);
        assertThat(bridge.stream().allMatch(v -> v.equals("U") || v.equals("D"))).isEqualTo(true);
    }
}
