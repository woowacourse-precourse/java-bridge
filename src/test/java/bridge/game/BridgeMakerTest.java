package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Nested
    class MakerTest {
        @DisplayName("다리 사이즈 생성을 10으로 주면 10사이즈의 다리가 반환이 되는가?")
        @Test
        void makeBridgeTest_1() {
            // given
            int size = 10;
            int result = 10;

            // when
            List<String> bridge = bridgeMaker.makeBridge(size);
            System.out.println("bridge = " + bridge);

            // then
            Assertions.assertThat(bridge.size())
                    .isEqualTo(result);
        }

        @DisplayName("생성된 다리에는 U와 D 데이터만 존재한다.")
        @Test
        void makeBridgeTest_2() {
            // given
            List<String> bridge = bridgeMaker.makeBridge(10);

            // when && then
            Assertions.assertThat(bridge)
                    .contains("U")
                    .contains("D");
        }
    }
}