package bridge;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame game;

    @BeforeEach
    void initialize() {

    }

    @Test
    void play_gameIsUnderAway_NOTHING_HAPPENED() {
        game = new BridgeGame(List.of("U", "U", "U", "D"));
        game.move(Direction.UP);
        Assertions.assertEquals(GameResult.NOTHING_HAPPENED, game.getGameResult());
    }

    @Test
    void play_nextIsUpAndUserSelectDown_USER_LOSE() {
        game = new BridgeGame(List.of("U"));
        game.move(Direction.DOWN);
        Assertions.assertEquals(GameResult.USER_LOSE, game.getGameResult());
    }

    @Test
    void play_nextIsDownAndUserSelectUp_USER_LOSE() {
        game = new BridgeGame(List.of("D"));
        game.move(Direction.UP);
        Assertions.assertEquals(GameResult.USER_LOSE, game.getGameResult());
    }

    @Test
    void play_nextIsUpAndUserSelectUp_USER_WIN() {
        game = new BridgeGame(List.of("D"));
        game.move(Direction.DOWN);
        Assertions.assertEquals(GameResult.USER_WIN, game.getGameResult());
    }

    @Test
    void play_nextIsDownAndUserSelectDown_USER_WIN() {
        game = new BridgeGame(List.of("U"));
        game.move(Direction.UP);
        Assertions.assertEquals(GameResult.USER_WIN, game.getGameResult());
    }

    @Test
    void retry_gameOver_reset() {
        game = new BridgeGame(List.of("U", "U", "D"));
        game.move(Direction.UP);
        game.move(Direction.UP);
        game.move(Direction.UP);
        Assertions.assertEquals(GameResult.USER_LOSE, game.getGameResult());
        game.retry();
        game.move(Direction.UP);
        game.move(Direction.UP);
        game.move(Direction.DOWN);
        Assertions.assertEquals(GameResult.USER_WIN, game.getGameResult());
    }
}
