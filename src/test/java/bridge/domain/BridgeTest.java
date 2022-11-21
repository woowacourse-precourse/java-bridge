package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void 다리_생성하기() throws Exception{
        //given
        List<String> bridge = bridgeMaker.makeBridge(10);

        //when
        Bridge newBridge = new Bridge(bridge, 10);

        //then
        assertThat(newBridge.getSize()).isEqualTo(10);
        assertThat(newBridge.getBridge()).allMatch(o->o.equals("U") || o.equals("D"));
    }
}