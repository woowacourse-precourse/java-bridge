package bridge;

import bridge.domain.Bridge;
import bridge.type.GameStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    static Bridge bridge;
    static GameStatusOperator gameStatusOperator;

    @BeforeAll
    static void initBridgeGame() {
        bridge = new Bridge(List.of("U", "D", "U", "D"));
        gameStatusOperator = new GameStatusOperator(-1, 0, GameStatus.START);
    }

    @DisplayName("플레이어가 다리에서 한 칸 이동한다.")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame(bridge, gameStatusOperator);
        bridgeGame.move();
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(currentPosition).isEqualTo(0);
    }

}