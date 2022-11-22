package bridge;

import bridge.position.Latitude;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest
    @ValueSource(ints = {10})
    @DisplayName("다리 길이가 요청 길이와 같은지, 원소값이 U 또는 D 인지 확인한다.")
    void makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertThat(bridge.stream().allMatch(Latitude::contains)).isEqualTo(true);
        Assertions.assertThat(bridge.size()).isEqualTo(size);
    }
}
