package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ConstValue;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    @DisplayName("랜덤한 모양을 가진 다리를 생성한다.")
    @Test
    void makeNewBridge() {
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int bridgeSize = 3;

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridge).containsAnyOf(ConstValue.LOWER_BRIDGE, ConstValue.UPPER_BRIDGE);
    }
}
