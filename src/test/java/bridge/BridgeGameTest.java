package bridge;

import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Player;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
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
    void moveTest() {
        MoveResponseDto move = bridgeGame.move("U");

        assertThat(player.getCommands().get(0)).isEqualTo(Command.UP);
        assertThat(move.getSelectedBridge()).isEqualTo("UP");
        assertThat(move.getResultBooleanType()).isTrue();
    }

    @Test
    void retryTest() {
        Command commandRetry = Command.RETRY;

        RetryResponseDto retry = bridgeGame.retry(commandRetry);

        assertThat(player.getAttemptCount()).isEqualTo(2);
        assertThat(retry.getAttemptCount()).isEqualTo(2);
        assertThat(retry.isRetryGame()).isTrue();
    }

    @Test
    void exitTest() {
        Command commandExit = Command.EXIT;

        RetryResponseDto exit = bridgeGame.retry(commandExit);

        assertThat(player.getAttemptCount()).isEqualTo(2);
        assertThat(exit.getAttemptCount()).isEqualTo(2);
        assertThat(exit.isRetryGame()).isFalse();
    }
}