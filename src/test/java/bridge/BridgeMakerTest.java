package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Collections;
import java.util.List;

public class BridgeMakerTest {
    @DisplayName("생성한 다리에 대한 길이 검증")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20})
    void makeBridgeWithAValueBetweenThreeAndTwenty(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge.size()).isEqualTo(bridgeSize);
        assertThat(Collections.frequency(bridge, "U") + Collections.frequency(bridge, "D"))
                .isEqualTo(bridgeSize);
    }
}
