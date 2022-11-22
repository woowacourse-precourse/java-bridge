package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리 생성 테스트")
    @Nested
    class MakeBridge {
        @DisplayName("아래 칸을 건널 수 있는 다리 생성 테스트")
        @Test
        void makeBridgeDown() {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator() {
                @Override
                public int generate() {
                    return 0;
                }
            });

            assertThat(bridgeMaker.makeBridge(3)).isEqualTo(List.of("D", "D", "D"));
        }

        @DisplayName("위 칸을 건널 수 있는 다리 생성 테스트")
        @Test
        void makeBridgeUp() {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator() {
                @Override
                public int generate() {
                    return 1;
                }
            });

            assertThat(bridgeMaker.makeBridge(3)).isEqualTo(List.of("U", "U", "U"));
        }

        @DisplayName("음수로는 다리를 생성할 수 없는 기능 테스트")
        @Test
        void makeBridgeMinus() {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

            assertThatThrownBy(() -> bridgeMaker.makeBridge(-1)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
