package bridge;

import bridge.util.BridgePosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @DisplayName("입력된 사이즈 만큼 다리를 생성한다")
    @Test
    void generateBridgeByBridgeSize() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int size = 10;

        List<String> strings = bridgeMaker.makeBridge(size);

        assertThat(strings.size()).isEqualTo(size);
    }

    @DisplayName("0이 입력되면 D를 반환한다")
    @Test
    void getBridgeDownPositionByBridgeNumber() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        String bridgePosition = bridgeMaker.getBridgePosition(0);

        assertThat(bridgePosition).isEqualTo(BridgePosition.DOWN.getBridgePosition());
    }

    @DisplayName("1이 입력되면 U를 반환한다")
    @Test
    void getBridgeUpPositionByBridgeNumber() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        String bridgePosition = bridgeMaker.getBridgePosition(1);

        assertThat(bridgePosition).isEqualTo(BridgePosition.UP.getBridgePosition());
    }
}
