package bridge;

import bridge.domain.constant.Constant;
import bridge.domain.Direction;
import bridge.domain.UserBridge;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserBridgeTest {
    private UserBridge userBridge = new UserBridge();

    @Test
    void 위칸_이동_테스트() {
        userBridge.moveUpBridge(Direction.U);
        assertThat(userBridge.getUpBridge().contains(Constant.CROSS)).isTrue();

        userBridge.moveUpBridge(Direction.D);
        assertThat(userBridge.getUpBridge().contains(Constant.CROSS_FAIL)).isTrue();
    }

    @Test
    void 아래칸_이동_테스트() {
        userBridge.moveDownBridge(Direction.U);
        assertThat(userBridge.getDownBridge().contains(Constant.CROSS_FAIL)).isTrue();

        userBridge.moveDownBridge(Direction.D);
        assertThat(userBridge.getDownBridge().contains(Constant.CROSS)).isTrue();
    }
}
