package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    Bridge bridge = new Bridge(List.of("U", "U", "U"));

    @DisplayName("다리를 성공적으로 건너면 MoveResult.SUCCESS 를 반환한다.")
    @Test
    void crossBridge() {
        assertThat(bridge.cross(new BridgeBlock(Direction.U, 0))).isEqualTo(MoveResult.SUCCESS);
    }

    @DisplayName("다리를 건너지 못하면 MoveResult.FAIL 를 반환한다.")
    @Test
    void crossBridgeFail() {
        assertThat(bridge.cross(new BridgeBlock(Direction.D, 0))).isEqualTo(MoveResult.FAIL);
    }
}
