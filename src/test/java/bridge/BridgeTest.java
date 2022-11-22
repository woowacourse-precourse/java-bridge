package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @Test
    public void make_bridge_test() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        //when
        int bridgeLength = 5;

        //then
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        assertThat(bridge.size()).isEqualTo(5);
        assertThat(bridge).containsOnly("D", "U");

    }
}