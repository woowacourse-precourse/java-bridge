package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("입력값과 같은 길이의 다리를 생성한다.")
    @Test
    void createBridgeSizeSameWithInputSize() {
        // given
        int bridgeLength = 6;

        // when
        List<String> bridge = bridgeMaker.makeBridge(6);

        // then
        assertThat(bridge.size()).isEqualTo(6);
    }

    @DisplayName("생성된 다리는 U와 D만을 포함한다.")
    @Test
    void bridgeContainUOrD() {
        // given
        int bridgeLength = 6;
        List<String> bridge = bridgeMaker.makeBridge(6);

        // when
        boolean componentOfBridge = bridge.contains("U") || bridge.contains("D");

        // then;
        assertThat(componentOfBridge).isTrue();
    }
}