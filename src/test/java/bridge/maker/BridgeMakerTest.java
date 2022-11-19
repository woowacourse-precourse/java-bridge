package bridge.maker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @Test
    @DisplayName("다리 크기 생성 테스트")
    void makeBridge() {
        final int BRIDGE_SIZE = 5;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        Assertions.assertThat(bridgeMaker.makeBridge(BRIDGE_SIZE).size()).isEqualTo(BRIDGE_SIZE);
    }
}