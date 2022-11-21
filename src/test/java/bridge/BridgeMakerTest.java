package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("주어진 사이즈에 해당하는 길이이고 U,D로 구성된 다리가 생성 여부 테스트")
    @Test
    void 다리_생성_테스트() {
        final int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge.stream().allMatch(ch -> ch == "U" || ch == "D")).isTrue();
    }
}