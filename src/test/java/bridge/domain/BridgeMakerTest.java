package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @Test
    public void makeBridge() {
        //given
        BridgeNumberGenerator bridgeNumberGenerator = new TestUpGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        //when
        List<String> bridge = bridgeMaker.makeBridge(3);

        //then
        assertThat(bridge).isEqualTo(List.of("U", "U", "U"));

    }

    static class TestUpGenerator implements BridgeNumberGenerator {

        @Override
        public int generate() {
            return 1;
        }
    }


}