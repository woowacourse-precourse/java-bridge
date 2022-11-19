package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리 길이 만큼 다리 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 7, 2, 0})
    void makeBridgeSizeTest(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }

    @DisplayName("다리 길이 만큼 다리 생성하는 테스트 - size 0보다 작은 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void makeBridgeMinusSizeTest(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(0);
    }
}
