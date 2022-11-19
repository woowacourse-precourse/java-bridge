package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final int BRIDGE_SIZE = 10;
    private final Bridge bridge = new Bridge(bridgeMaker.makeBridge(BRIDGE_SIZE), BRIDGE_SIZE);

    @DisplayName("U나 D가 입력 됐을 때 이동 가능한지 판별하는 기능이 제대로 동작하는지 테스트")
    @Test
    void bridgePossibleMoveTest() {
        boolean ret;
        ret = bridge.possibleMove("U");
        if (!ret) {
            ret = bridge.possibleMove("D");
        }
        assertThat(ret).isEqualTo(true);
    }
}
