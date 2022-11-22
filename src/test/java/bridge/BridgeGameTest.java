package bridge;

import bridge.BridgeGame.Direction;
import bridge.BridgeGame.Result;
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
        game = new BridgeGame(List.of("U","U","U","D"));
        Assertions.assertEquals(Result.NOTHING_HAPPENED, game.play(Direction.UP));
    }

    @Test
    void play_nextIsUpAndUserSelectDown_USER_LOSE() {
        game = new BridgeGame(List.of("U"));
        Assertions.assertEquals(Result.USER_LOSE, game.play(Direction.DOWN));
    }

    @Test
    void play_nextIsDownAndUserSelectUp_USER_LOSE() {
        game = new BridgeGame(List.of("D"));
        Assertions.assertEquals(Result.USER_LOSE, game.play(Direction.UP));
    }

    @Test
    void play_nextIsUpAndUserSelectUp_USER_WIN() {
        game = new BridgeGame(List.of("D"));
        Assertions.assertEquals(Result.USER_WIN, game.play(Direction.DOWN));
    }

    @Test
    void play_nextIsDownAndUserSelectDown_USER_WIN() {
        game = new BridgeGame(List.of("U"));
        Assertions.assertEquals(Result.USER_WIN, game.play(Direction.UP));
    }

    @Test
    void retry_gameOver_reset() {
        game = new BridgeGame(List.of("U","U","D"));
        game.play(Direction.UP);
        game.play(Direction.UP);
        Assertions.assertEquals(Result.USER_LOSE, game.play(Direction.UP));
        game.retry();
        game.play(Direction.UP);
        game.play(Direction.UP);
        Assertions.assertEquals(Result.USER_WIN, game.play(Direction.DOWN));
    }
}
