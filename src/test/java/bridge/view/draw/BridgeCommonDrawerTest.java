package bridge.view.draw;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeStatus;
import bridge.domain.MovingCommand;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeCommonDrawerTest {

    @DisplayName("게임 진행시에는 O만 출력해야함")
    @Test
    void mustReturnOWhenInProgress() {
        // given
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(List.of("U", "D", "U"));
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        BridgeCommonDrawer bridgeCommonDrawer = new BridgeCommonDrawer(bridgeStatus.getUserBridge());

        // when
        String result = bridgeCommonDrawer.draw();

        // then
        assertThat(result).isEqualTo("[ O ]\n[   ]");
    }

    @DisplayName("성공시에는 O만 출력해야함")
    @Test
    void mustReturnOWhenSuccess() {
        // given
        BridgeStatus bridgeStatus = makeBridgeStatus();
        BridgeCommonDrawer bridgeCommonDrawer = new BridgeCommonDrawer(bridgeStatus.getUserBridge());

        // when
        String result = bridgeCommonDrawer.draw();

        // then
        assertThat(result).isEqualTo("[ O |   | O ]\n[   | O |   ]");
    }

    private BridgeStatus makeBridgeStatus() {
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(List.of("U", "D", "U"));
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        bridgeStatus.addUserMovingCommand(MovingCommand.DOWN);
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        return bridgeStatus;
    }
}