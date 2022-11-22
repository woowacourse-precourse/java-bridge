package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakeTest {
    BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3,5,7,11})
    void makeBridege(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Assertions.assertThat(bridge.size()).as("개수 반환 확인").isEqualTo(bridgeSize);
    }
}
