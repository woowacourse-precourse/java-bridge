package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("다리의 길이는 입력받은 값으로 설정합니다.")
    @Test
    void makeBridge_size() {
        assertThat(bridgeMaker.makeBridge(3).size())
                .isEqualTo(3);
    }

    @DisplayName("다리는 U 와 D 로만 구성되어 있습니다.")
    @Test
    void makeBridge_component() {
        assertThat(bridgeMaker.makeBridge(3).stream()
                .allMatch(element -> element.equals(UP) || element.equals(DOWN)))
                .isTrue();
    }
}