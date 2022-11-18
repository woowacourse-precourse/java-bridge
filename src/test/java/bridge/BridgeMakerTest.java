package bridge;

import bridge.controller.BridgeMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트() {
        int size = 4;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeStr =  bridgeMaker.makeBridge(size);
        int result = bridgeStr.size();
        System.out.println(bridgeStr);
        assertThat(size).isEqualTo(result);
    }
}