package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void 다리_길이가_5일_때_길이가_5인_다리가_생성된다() {
        int bridgeSize = 5;
        assertThat(bridgeMaker.makeBridge(5).size()).isEqualTo(bridgeSize);
    }
}