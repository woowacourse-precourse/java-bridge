package bridge.domain.bridgegame;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void 다리_생성_사이즈_테스트() {
        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3);
        assertThat(bridgeMaker.makeBridge(20).size()).isEqualTo(20);
    }

    @Test
    void 다리_구성_요소_테스트() {
        assertThat(bridgeMaker.makeBridge(20)).containsAnyOf("U", "D");
    }

}