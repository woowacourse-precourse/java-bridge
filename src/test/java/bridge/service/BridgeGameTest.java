package bridge.service;

import bridge.MoveResponseDto;
import bridge.RetryResponseDto;
import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;
    Player player;

    @BeforeEach
    void init() {
        Bridge bridge = new Bridge(List.of(Command.UP, Command.UP, Command.DOWN));
        player = new Player();
        bridgeGame = new BridgeGame(bridge, player);
    }

    @Test
    @DisplayName("사용자가 칸을 이동할 때 사용하는 메서드 테스트")
    void moveTest() {
        MoveResponseDto move = bridgeGame.move("U");

        assertThat(player.getCommands().get(0)).isEqualTo(Command.UP);
        assertThat(move.getSelectedBridge()).isEqualTo("UP");
        assertThat(move.getResultBooleanType()).isTrue();
    }

    @Test
    @DisplayName("사용자가 재시작 할때 사용하는 메서드 테스트")
    void retryTest() {
        Command commandRetry = Command.RETRY;

        RetryResponseDto retry = bridgeGame.retry(commandRetry);

        assertThat(player.getAttemptCount()).isEqualTo(2);
        assertThat(retry.getAttemptCount()).isEqualTo(2);
        assertThat(retry.isRetryGame()).isTrue();
    }

    @Test
    @DisplayName("사용자가 종료 할때 사용하는 메서드 테스트")
    void exitTest() {
        Command commandExit = Command.EXIT;

        RetryResponseDto exit = bridgeGame.retry(commandExit);

        assertThat(player.getAttemptCount()).isEqualTo(2);
        assertThat(exit.getAttemptCount()).isEqualTo(2);
        assertThat(exit.isRetryGame()).isFalse();
    }
}