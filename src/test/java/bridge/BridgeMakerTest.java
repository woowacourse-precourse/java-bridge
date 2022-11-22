package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    private final int SIZE = 10;
    private List<String> bridge;

    @BeforeEach
    void setUp() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(SIZE);
    }

    @DisplayName("다리 생성 시, 다리 길이에 맞는 크기의 List 가 생성되어야 한다")
    @Test
    void makeBridgeWithRequestedLength() {
        assertThat(bridge.size()).isEqualTo(SIZE);
    }

    @DisplayName("생성된 다리가 U, 또는 D 의 문자열로 구성되어야 한다.")
    @Test
    void checkBridgeMovePosition() {
        String MOVE_UP = "U";
        String MOVE_DOWN = "D";

        assertThat(bridge).containsOnly(MOVE_DOWN, MOVE_UP);
    }
}
