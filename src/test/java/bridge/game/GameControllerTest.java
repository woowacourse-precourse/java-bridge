package bridge.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private static GameController gameController = new GameController();

    @BeforeAll
    @Test
    static void 게임_실행() {

        assertTrue(gameController.runGame());

    }

    @Test
    void 게임_재시도() {

        String input = "R";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertTrue(gameController.retryGame());

    }

    @Test
    void 게임_종료() {

        String input = "Q";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertFalse(gameController.retryGame());

    }

}