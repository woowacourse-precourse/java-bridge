package bridge.view;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMakerTest {
    @Test
    @DisplayName("건널 수 있는 칸에 따라 다리를 만든다.")
    void 건널_수_있는_칸에_따라_다리를_만든다() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        // when
        int[] accessibleSpots = {1, 0, 1, 1, 1, 0, 0, 0, 1, 0};
        List<String> bridge = bridgeMaker.makeBridge(accessibleSpots);

        // then
        Assertions.assertThat(bridge).isEqualTo(Arrays.asList("U", "D", "U", "U", "U", "D", "D", "D", "U", "D"));
    }
}
