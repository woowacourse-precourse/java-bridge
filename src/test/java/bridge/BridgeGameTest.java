package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.GameCommand;
import bridge.model.GameMap;
import bridge.model.Player;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;
    GameMap gameMap;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "D", "U")), new Player());
        gameMap = new GameMap();
    }

    @Test
    void 실패하고나서_재시도_한_경우_게임_결과는_실패이고_시도_횟수는_두번이어야_한다() {
        bridgeGame.move(Direction.D);
        assertThat(bridgeGame.end()).isTrue();

        bridgeGame.retry(GameCommand.R, gameMap);
        assertThat(bridgeGame.end()).isFalse();

        bridgeGame.move(Direction.U);
        bridgeGame.move(Direction.D);
        GameResult gameResult = bridgeGame.gameResult();

        assertThat(gameResult.getResult()).isEqualTo("실패");
        assertThat(gameResult.getRetryCount()).isEqualTo(2);
    }
}