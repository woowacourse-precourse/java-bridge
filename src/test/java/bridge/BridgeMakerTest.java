package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Nested
    @DisplayName("다리 생성 테스트")
    class MakeBridgeTest {

        @Test
        @DisplayName("다리 생성 테스트")
        void makeBridgeTest() {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge).containsExactly("U", "D", "D");
        }
    }
}
