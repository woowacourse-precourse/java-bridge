package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeStatusTest {

    @DisplayName("이미 성공한 경우에 입력 요청한 경우 예외 발생")
    @Test
    void throwExceptionWhenGameStatusIsSuccess() {
        // given
        List<String> bridge = List.of("U","D","U");
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);

        // expect
        assertThatThrownBy(() -> {
            bridgeStatus.addUserMovingCommand(MovingCommand.UP);
            bridgeStatus.addUserMovingCommand(MovingCommand.DOWN);
            bridgeStatus.addUserMovingCommand(MovingCommand.UP);
            bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        }).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("이미 실패한 경우에 입력 요청한 경우 예외 발생")
    @Test
    void throwExceptionWhenGameStatusIsFail() {
        // given
        List<String> bridge = List.of("U","D","U");
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);

        // expect
        assertThatThrownBy(() -> {
            bridgeStatus.addUserMovingCommand(MovingCommand.UP);
            bridgeStatus.addUserMovingCommand(MovingCommand.UP);
            bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        }).isInstanceOf(IllegalStateException.class);
    }


}