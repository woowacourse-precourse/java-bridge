package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bridge.domain.BridgeLength;
import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;
import bridge.domain.MovingCommand;
import bridge.domain.RetryCommand;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private final BridgeStatusSaver bridgeStatusSaver = new BridgeStatusSaver();
    private final BridgeMaker bridgeMaker = mock(BridgeMaker.class);
    private final BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeStatusSaver);

    @DisplayName("다리 생성시 영속화 테스트")
    @Test
    void persistBridgeStatusWhenCreateBridge() {
        // given
        when(bridgeMaker.makeBridge(anyInt())).thenReturn(List.of("U", "D", "U"));

        // when
        bridgeGame.createBridge(new BridgeLength(3));

        // then
        assertThat(bridgeStatusSaver.getBridgeStatus()).isNotNull();
    }

    @DisplayName("움직임 명령 요청시 영속화 테스트")
    @Test
    void persistBridgeStatusWhenRequestMovingCommand() {
        // given
        when(bridgeMaker.makeBridge(anyInt())).thenReturn(List.of("U", "D", "U"));
        bridgeGame.createBridge(new BridgeLength(3));
        BridgeStatus original = bridgeStatusSaver.getBridgeStatus();

        // when
        bridgeGame.move(MovingCommand.UP);

        // then
        assertThat(bridgeStatusSaver.getBridgeStatus()).isNotNull();
    }

    @DisplayName("retry 요청시 R인 경우 true, Q인 경우 false 반환")
    @ParameterizedTest
    @CsvSource({
            "R, true", "Q, false"
    })
    void returnTrueWhenRequestRorReturnFalseWhenRequestQ(String input, boolean result) {
        // given
        when(bridgeMaker.makeBridge(anyInt())).thenReturn(List.of("U", "D", "U"));
        bridgeGame.createBridge(new BridgeLength(3));
        RetryCommand retryCommand = RetryCommand.nameOf(input);

        // when
        boolean retry = bridgeGame.retry(retryCommand);

        // then
        assertThat(retry).isEqualTo(result);
    }

    @DisplayName("retry 요청시 true인 경우 userBridge 정보 및 게임 상태 초기화")
    @Test
    void resetUserBridgeAndGameStatusWhenRetryEqualsTrue() {
        // given
        when(bridgeMaker.makeBridge(anyInt())).thenReturn(List.of("U", "D", "U"));
        bridgeGame.createBridge(new BridgeLength(3));

        // when
        bridgeGame.retry(RetryCommand.nameOf("R"));

        // then
        assertThat(bridgeStatusSaver.getBridgeStatus().getUserBridge()).isEmpty();
        assertThat(bridgeStatusSaver.getBridgeStatus().getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);
    }
}