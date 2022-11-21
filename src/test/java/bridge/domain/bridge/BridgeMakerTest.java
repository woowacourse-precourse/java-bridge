package bridge.domain.bridge;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    private void init() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @Test
    @DisplayName("다리 생성 시 U, D만 포함될 수 있다.")
    void 다리_구성_문자열_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(3);

        Assertions.assertThat(bridge).allMatch(b -> List.of("U", "D").contains(b));
    }

    @Test
    @DisplayName("다리 생성 시 입력된 사이즈 만큼 생성된다.")
    void 다리_길이_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(3);

        Assertions.assertThat(bridge.size()).isEqualTo(3);
    }
}
