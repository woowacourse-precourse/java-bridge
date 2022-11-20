package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame game;

    @BeforeEach
    void init() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        game = new BridgeGame();
        game.initBridge(bridgeMaker.makeBridge(3));
    }

    @Test
    void move() {
        game.move(BridgeGame.CMD_UP);
        Assertions.assertThat(game.getPosition()).isEqualTo(1);
        Assertions.assertThat(game.getLastCommand()).isEqualTo(BridgeGame.CMD_UP);
    }

    @Test
    void retry() {
        game.retry();
        Assertions.assertThat(game.getTryCount()).isEqualTo(2);
        game.retry();
        Assertions.assertThat(game.getTryCount()).isEqualTo(3);
    }

    @Test
    void isPlayerAlive() {
        Assertions.assertThat(game.isPlayerAlive()).isEqualTo(true);
        game.move(BridgeGame.CMD_DOWN);
        Assertions.assertThat(game.isPlayerAlive()).isEqualTo(false);
    }

    @Test
    void isSuccess_true() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_DOWN);
        Assertions.assertThat(game.isSuccess()).isEqualTo(true);
    }

    @Test
    void isSuccess_false() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_UP);
        Assertions.assertThat(game.isSuccess()).isEqualTo(false);
    }

    @Test
    void getGameResultToString_success() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_DOWN);
        Assertions.assertThat(game.getGameResultToString()).isEqualTo("성공");
    }

    @Test
    void getGameResultToString_failed() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_UP);
        Assertions.assertThat(game.getGameResultToString()).isEqualTo("실패");
    }
}