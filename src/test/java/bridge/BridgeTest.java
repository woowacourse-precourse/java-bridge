package bridge;

import bridge.View.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    @Test
    void makeBridgeTest () {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeMaker.makeBridge(inputView.readBridgeSize());
        assertThat(bridgeMaker).
    }
}
