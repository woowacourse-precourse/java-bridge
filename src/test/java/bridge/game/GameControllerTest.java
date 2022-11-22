package bridge.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private static GameController gameController = new GameController();
    private static Game game;

    @BeforeAll
    @Test
    static void 게임_실행() {
        game = gameController.runGame();
        assertTrue(game.getRunStatus().isStatus());

    }

    @Test
    void 게임_재시도() {

        String input = "R";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        gameController.retryGame();

        assertTrue(game.getRunStatus().isStatus());

    }

    @Test
    void 게임_종료() {

        String input = "Q";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        gameController.retryGame();

        assertFalse(game.getRunStatus().isStatus());

    }

}