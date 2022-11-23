package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeStatusTest {

    @DisplayName("처음 생성시 시도 횟수는 1로 초기화 해야함")
    @Test
    void initOneWhenCreateBridgeStatus() {
        // given
        List<String> bridge = List.of("U", "D", "U");

        // when
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);

        // then
        assertThat(bridgeStatus.getTryCount()).isEqualTo(1);
    }

    @DisplayName("이미 성공한 경우에 입력 요청한 경우 예외 발생")
    @Test
    void throwExceptionWhenGameStatusIsSuccess() {
        // given
        List<String> bridge = List.of("U", "D", "U");
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);

        // expect
        assertThatThrownBy(() -> {
            makeSuccessGameStatus(bridgeStatus);
            bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        }).isInstanceOf(IllegalStateException.class);
    }

    private void makeSuccessGameStatus(BridgeStatus bridgeStatus) {
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        bridgeStatus.addUserMovingCommand(MovingCommand.DOWN);
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
    }

    @DisplayName("이미 실패한 경우에 입력 요청한 경우 예외 발생")
    @Test
    void throwExceptionWhenGameStatusIsFail() {
        // given
        List<String> bridge = List.of("U", "D", "U");
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);

        // expect
        assertThatThrownBy(() -> requestAddCommandWhenFail(bridgeStatus)).isInstanceOf(IllegalStateException.class);
    }

    private void requestAddCommandWhenFail(BridgeStatus bridgeStatus) {
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
    }

    @DisplayName("게임 상태가 성공인 경우 재시작 요청 여부는 false")
    @Test
    void returnTrueWhenGameStatusIsSuccess() {
        // given
        List<String> bridge = List.of("U", "D", "U");
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);

        // when
        makeSuccessGameStatus(bridgeStatus);

        // then
        assertThat(bridgeStatus.needCallRetryGame()).isEqualTo(false);
    }

    @DisplayName("게임 상태가 실패인 경우 재시작 요청 여부는 true")
    @Test
    void returnTrueWhenGameStatusIsFail() {
        // given
        List<String> bridge = List.of("U", "D", "U");
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);

        // when
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);
        bridgeStatus.addUserMovingCommand(MovingCommand.UP);

        // then
        assertThat(bridgeStatus.needCallRetryGame()).isEqualTo(true);
    }
}