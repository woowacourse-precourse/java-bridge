package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @Test
    void makeBridgeSizeTest1() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        assertThat(bridgeMaker.makeBridge(5).size())
                .isEqualTo(5);
    }
}