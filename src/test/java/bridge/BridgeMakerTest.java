package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Nested
    @DisplayName("다리를 생성하는 기능")
    class isFinished {
        @Test
        @DisplayName("지정된 길이와 다리 길이가 같아야 됨")
        void rightCase() {
            int size = 3;
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.size()).isEqualTo(size);
        }

        @Test
        @DisplayName("다리는 U 또는 D로 이루어져 있음")
        void rightCase2() {
            int size = 3;
            List<String> bridge = bridgeMaker.makeBridge(size);

            assertThat(bridge.stream().noneMatch(c -> !c.equals("U") && !c.equals("D"))).isTrue();
        }

    }
}