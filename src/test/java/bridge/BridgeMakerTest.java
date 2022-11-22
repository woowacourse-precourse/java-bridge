package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    @DisplayName("다리 생성 테스트")
    void 생성한_다리_길이_테스트(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(bridgeSize).size())
                .isEqualTo(bridgeSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    @DisplayName("U 또는 D 포함 테스트")
    void 다리_저장_포맷_테스트(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(bridgeSize))
                .toString()
                .matches("UD");
    }
}
