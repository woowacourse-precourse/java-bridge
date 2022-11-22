package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("방향에 대한 숫자가 1일 경우 위쪽 방향에 다리가 생성된다.")
    @Test
    void makeUpBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);
        List<String> bridge = bridgeMaker.makeBridge(1);

        assertThat(bridge).hasSize(1);
        assertThat(bridge).containsExactly("U");
    }

    @DisplayName("방향에 대한 숫자가 0일 경우 아래쪽 방향에 다리가 생성된다.")
    @Test
    void makeDownBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);
        List<String> bridge = bridgeMaker.makeBridge(1);

        assertThat(bridge).hasSize(1);
        assertThat(bridge).containsExactly("D");
    }
}
