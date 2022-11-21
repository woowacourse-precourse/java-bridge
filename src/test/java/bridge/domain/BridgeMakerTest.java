package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeMakerTest {

    @Test
    void 랜덤_다리_생성(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int length = 5;

        assertThat(bridgeMaker.makeBridge(length).size()).isEqualTo(length);
    }
}