package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.GameCommand;
import bridge.domain.MoveCommand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    @Test
    void MoveCommand에_맞게_이동하는지_테스트() {
        List<String> bridge = List.of("U", "U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.move(MoveCommand.UP)).isTrue();
        assertThat(bridgeGame.move(MoveCommand.DOWN)).isFalse();
        assertThat(bridgeGame.move(MoveCommand.DOWN)).isTrue();
        assertThat(bridgeGame.move(MoveCommand.UP)).isFalse();
    }

    @Test
    void GameCommand에_맞게_재시작_하는지_테스트() {
        List<String> bridge = List.of("U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.retry(GameCommand.REPLAY)).isTrue();
        assertThat(bridgeGame.retry(GameCommand.QUIT)).isFalse();
    }

}