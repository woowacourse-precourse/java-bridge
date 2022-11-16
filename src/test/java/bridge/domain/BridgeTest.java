package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("생성한 사이즈가 변화 하는지 확인")
    @ParameterizedTest(name = "[{index}] 번째 테스트 : size {0}")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    void BridgeSizeTest(int expected) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(expected));
        int actual = bridge.getBridgeSize();
        assertThat(actual).isEqualTo(expected);
    }

}