package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
        MoveResponseDto move = bridgeGame.move(Command.UP);

        assertThat(player.getCommands().get(0)).isEqualTo(Command.UP);
        assertThat(move.getSelectedBridge()).isEqualTo("UP");
        assertThat(move.getResultBooleanType()).isTrue();
    }

    //에외 테스트
}