package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;
    BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach()
    void beforeEach() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("생성된 다리는 U와 D로 이루어져야한다.")
    @RepeatedTest(10)
    void bridgeCreateStringTest() {
        List<String> bridge = bridgeMaker.makeBridge(15);
        for (String moving : bridge) {
            assertThat(List.of("U", "D").contains(moving)).isTrue();
        }
    }

    @DisplayName("다리의 길이는 사용자에게 입력받은 값이다")
    @RepeatedTest(10)
    void bridgeCreateSizeTest() {
        List<String> bridge = bridgeMaker.makeBridge(15);
        assertThat(bridge.size()).isEqualTo(15);
    }
}