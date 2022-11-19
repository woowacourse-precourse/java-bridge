package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {
    @DisplayName("다리 생성 성공")
    @Test
    void createBridgeSuccess() {
        assertThatCode(() -> {
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            bridgeMaker.makeBridge(10);
        }).doesNotThrowAnyException();
    }

    @DisplayName("다리 길이가 정상적인지 확인")
    @Test
    void checkBridgeSize() {
        int bridgeSize = 10;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }
}
