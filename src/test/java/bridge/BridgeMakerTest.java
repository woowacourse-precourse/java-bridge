package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("위에 다리가 생성된다.")
    @Test
    void makeUpBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);

        assertThat(bridgeMaker.makeBridge(1)).hasSize(1);
        assertThat(bridgeMaker.makeBridge(1)).containsExactly("U");
    }

    @DisplayName("아래에 다리가 생성된다.")
    @Test
    void makeDownBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);

        assertThat(bridgeMaker.makeBridge(1)).hasSize(1);
        assertThat(bridgeMaker.makeBridge(1)).containsExactly("D");
    }
}
