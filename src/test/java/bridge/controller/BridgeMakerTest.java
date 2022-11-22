package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

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