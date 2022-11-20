package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeTestNumberGenerator());

    @Test
    void checkBridgeSize(){
        int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }

}