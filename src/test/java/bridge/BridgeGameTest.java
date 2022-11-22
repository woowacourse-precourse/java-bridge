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
        bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U")), new Player(), new GameMap());
        gameMap = new GameMap();
    }

    @Test
    void 실패하고나서_재시도_한_경우_게임_결과는_실패이고_시도_횟수는_두번이어야_한다() {
        bridgeGame.move(Direction.DOWN);
        assertThat(bridgeGame.fail()).isTrue();

        bridgeGame.retry(GameCommand.RESTART);
        assertThat(bridgeGame.fail()).isFalse();

        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);
        GameResult gameResult = bridgeGame.gameResult();

        assertThat(gameResult.getResult()).isEqualTo("실패");
        assertThat(gameResult.getRetryCount()).isEqualTo(2);
    }

    @Test
    void 다리_끝까지_건너면_게임_결과는_성공이어야한다() {
        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);
        bridgeGame.move(Direction.UP);

        assertThat(bridgeGame.quit()).isTrue();

        GameResult gameResult = bridgeGame.gameResult();

        assertThat(gameResult.getResult()).isEqualTo("성공");
        assertThat(gameResult.getRetryCount()).isEqualTo(1);
    }

    @Test
    void 마지막_다리에서_실패하면_게임_결과는_실패여야한다() {
        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);
        bridgeGame.move(Direction.DOWN);

        assertThat(bridgeGame.quit()).isFalse();

        GameResult gameResult = bridgeGame.gameResult();

        assertThat(gameResult.getResult()).isEqualTo("실패");
        assertThat(gameResult.getRetryCount()).isEqualTo(1);
    }

    @Test
    void 게임종료를_입력하면_정상적으로_종료되어야한다() {
        bridgeGame.move(Direction.DOWN);
        assertThat(bridgeGame.fail()).isTrue();

        bridgeGame.retry(GameCommand.QUIT);
        GameResult gameResult = bridgeGame.gameResult();

        assertThat(gameResult.getResult()).isEqualTo("실패");
        assertThat(gameResult.getRetryCount()).isEqualTo(1);
    }
}