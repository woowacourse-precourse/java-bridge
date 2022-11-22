package bridge;

import static bridge.BridgeMaker.DOWN_BRIDGE;
import static bridge.BridgeMaker.UP_BRIDGE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    @DisplayName("다리의 길이를 받고 길이만큼 다리 생성,값은 U와D")
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridges = bridgeMaker.makeBridge(10);
        assertThat(bridges).matches(s -> s.size() == 10);
        assertThat(bridges).allMatch(value -> value.equals(UP_BRIDGE) || value.equals(DOWN_BRIDGE))
                .contains(UP_BRIDGE, DOWN_BRIDGE);
    }
}
