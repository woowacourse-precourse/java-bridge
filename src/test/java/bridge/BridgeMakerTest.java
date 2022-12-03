package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    @Test
    void makeBridgeShorterThanMinimumLength() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void makeBridgeLongerThanMinimumLength() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(21)).isInstanceOf(IllegalArgumentException.class);
    }
}