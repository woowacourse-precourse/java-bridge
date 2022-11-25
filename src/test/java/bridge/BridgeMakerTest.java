package bridge;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @Test
    void get_iput_and_build_bridge_checksize() {
        BridgeMaker bridgeMaker = new BridgeMaker(null);
        int targetSize = 4;
        List<String> bridge=bridgeMaker.makeBridge(targetSize);
        assertThat(bridge.size()).isEqualTo(targetSize);
    }
}