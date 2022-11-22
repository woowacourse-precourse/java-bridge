package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    private static final int bridgeSize = 10;
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static List<String> bridge;

    @BeforeAll
    static void setBridge() {
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }


    @DisplayName("입력된 다리 길이를 갖는 랜덤 다리가 생성된다.")
    @Test
    void createRandomBridge() {
        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }

    @DisplayName("생성된 랜덤 다리는 'U'와 'D'로 구성되어 있다.")
    @Test
    void checkRandomBridgeElement() {
        assertThat(Collections.frequency(bridge, "U") + Collections.frequency(bridge, "D")).isEqualTo(bridgeSize);
    }
}
