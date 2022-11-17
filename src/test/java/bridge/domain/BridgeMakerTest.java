package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeMakerTest {
    @Test
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list = bridgeMaker.makeBridge(10);
        assertThat(list.size()).isEqualTo(10);
        assertThat(list).contains("U", "D");
    }
}