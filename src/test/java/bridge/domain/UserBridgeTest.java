package bridge.domain;

import static bridge.constant.MovingDirection.D;
import static bridge.constant.MovingDirection.U;

import bridge.constant.MovingDirection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserBridgeTest {

    @Test
    void 입력한_다리방향중에_원하는_다리위치_방향반환성공() throws Exception {
        UserBridge userBridge = new UserBridge();
        userBridge.setMovement(U);
        userBridge.setMovement(D);
        userBridge.setMovement(U);
        MovingDirection movingDirection = userBridge.getMovingDirection(2);
        Assertions.assertThat(movingDirection).isEqualTo(U);
    }

}