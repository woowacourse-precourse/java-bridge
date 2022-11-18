package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMakerTest {
    @DisplayName("만들어진 다리의 길이 확인하기")
    @Test
    void makeBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge.size()).isEqualTo(5);
    }

    @DisplayName("다리의 길이가 20보다 큰 경우")
    @Test
    void makeBridgeByMoreThan20() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertThatThrownBy(
                () -> bridgeMaker.makeBridge(21)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3보다 작은 경우")
    @Test
    void makeBridgeByLessThan3() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertThatThrownBy(
                () -> bridgeMaker.makeBridge(1)).isInstanceOf(IllegalArgumentException.class);
    }
}
