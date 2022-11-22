package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest extends IOTest{
    @Test
    void 다리_사이즈_테스트() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> newBridge = bridgeMaker.makeBridge(3);
        System.out.println(newBridge);
        assertThat(newBridge.size()).isEqualTo(3);
    }

    @Test
    void 올바른_사이즈_테스트2() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(21).size()).isEqualTo(21);
    }

}
