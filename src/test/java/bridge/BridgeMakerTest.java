package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private static final int SIZE = 10;
    private static List<String> bridge;
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @BeforeEach
    void setUp() {
        bridge = bridgeMaker.makeBridge(SIZE);
    }

    @DisplayName("다리의 길이를 입력된 수 만큼 생성")
    @Test
    void makeBridgeSize() {
        assertThat(bridge.size()).isEqualTo(SIZE);
    }

    @DisplayName("생성된 다리는 U, D로 구성")
    @Test
    void makeBridgeString() {
        bridge.forEach(target ->
                assertThat(target).isIn("U", "D"));
    }
}