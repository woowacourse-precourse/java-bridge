package bridge;

import bridge.game.BridgeMaker;
import bridge.game.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    @Test
    void testMakeBridge() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int length = 8;
        List<String> bridge = maker.makeBridge(length);

        Assertions.assertThat(bridge).isNotNull();
        Assertions.assertThat(bridge.size()).isEqualTo(length);
        Assertions.assertThat(bridge).containsAnyOf("U", "D");
    }

}