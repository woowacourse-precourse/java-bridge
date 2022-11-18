package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final int BRIDGE_SIZE = 10;
    private final List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);

    @DisplayName("다리의 길이가 인자로 주어진 값 만큼 만들어지는지 테스트")
    @Test
    void makeBridgeSizeTest() {
        assertThat(bridge.size()).isEqualTo(BRIDGE_SIZE);
    }

    @DisplayName("만들어진 다리가 U와 D만 포함하고 있는지 테스트")
    @Test
    void makeBridgeContentTest() {
        assertThat(bridge).containsOnly("U", "D");
    }
}
