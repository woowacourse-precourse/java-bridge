package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class BridgeMakerTest {
    @DisplayName("다리가 D와 U로만 이루어져있는지 테스트")
    @Test
    void make_bridge_test() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);

        for (String b:bridge) {
            boolean right = false;
            if (b.equals("D") || b.equals("U"))  {
                right = true;
            };
            assertThat(right).isEqualTo(true);
        }
    };
}