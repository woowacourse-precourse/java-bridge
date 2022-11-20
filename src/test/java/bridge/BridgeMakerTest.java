package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void 입력된_다리_길이와_같은_길이로_다리_생성(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }

    @Test
    void 다리_생성_모양은_U_또는_D로_구성() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(20);
        boolean isBridgeShapeUOrD = bridge.contains("U") || bridge.contains("D");

        assertThat(isBridgeShapeUOrD).isTrue();
    }
}