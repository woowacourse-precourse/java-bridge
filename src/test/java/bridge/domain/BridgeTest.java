package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    @Test
    void 다리_생성(){
        String good = "6";
        String notNumeric = "a";
        String notLengthRange = "30";

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> resultBridge = bridgeMaker.makeBridge(4);
        Bridge bridge = new Bridge(4,resultBridge);

        assertThat(4).isEqualTo(bridge.getBridgeLength());
    }
}