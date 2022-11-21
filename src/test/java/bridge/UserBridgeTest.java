package bridge;

import bridge.domain.util.Rules;
import bridge.domain.Direction;
import bridge.domain.UserBridge;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserBridgeTest {
    private UserBridge userBridge = new UserBridge();

    @Test
    void 위칸_이동_테스트() {
        userBridge.moveUpBridge(Direction.U);
        assertThat(userBridge.getUpBridge().contains(Rules.CROSS)).isTrue();

        userBridge.moveUpBridge(Direction.D);
        assertThat(userBridge.getUpBridge().contains(Rules.CROSS_FAIL)).isTrue();
    }

    @Test
    void 아래칸_이동_테스트() {
        userBridge.moveDownBridge(Direction.U);
        assertThat(userBridge.getDownBridge().contains(Rules.CROSS_FAIL)).isTrue();

        userBridge.moveDownBridge(Direction.D);
        assertThat(userBridge.getDownBridge().contains(Rules.CROSS)).isTrue();
    }
}
