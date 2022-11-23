package bridge.view.draw;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeStatus;
import bridge.domain.MovingCommand;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeFailDrawerTest {

    @DisplayName("게임 상태 실패 시 마지막 다리 상태 결과는 X여야 함")
    @Test
    void returnLastBridgeXWhenGameStatusFail() {
        // given
        BridgeStatus bridgeStatus = makeBridgeStatus();
        BridgeDrawer bridgeDrawer = new BridgeFailDrawer(bridgeStatus.getUserBridge());

        // when
        String result = bridgeDrawer.draw();

        // then
        assertThat(result).isEqualTo("[ O | X ]\n[   |   ]");
    }

    private BridgeStatus makeBridgeStatus() {
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(List.of("U", "D", "U"));
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        return bridgeStatus;
    }
}