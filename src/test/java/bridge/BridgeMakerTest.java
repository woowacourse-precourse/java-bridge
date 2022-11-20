package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @Test
    public void 다리_생성_테스트() {
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