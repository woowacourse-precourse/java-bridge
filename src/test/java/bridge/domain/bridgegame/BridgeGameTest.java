package bridge.domain.bridgegame;

import bridge.io.output.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;
    OutputView outputView;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printStream = System.out;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(printStream);
    }

    @Test
    void move_메서드_위_칸_테스트() {
        bridgeGame.move("U", true, 0);
        GameStatus gameStatus = bridgeGame.getGameStatus();

        System.out.print("[ " + gameStatus.getUpBridge() + " ]");
        System.out.print("[ " + gameStatus.getDownBridge() + " ]");

        assertEquals("[ O ][   ]", out.toString());
    }

    @Test
    void move_메서드_위_칸_실패_테스트() {
        bridgeGame.move("U", false, 0);
        GameStatus gameStatus = bridgeGame.getGameStatus();

        System.out.print("[ " + gameStatus.getUpBridge() + " ]");
        System.out.print("[ " + gameStatus.getDownBridge() + " ]");

        assertEquals("[ X ][   ]", out.toString());
    }

    @Test
    void move_메서드_아래_칸_테스트() {
        bridgeGame.move("D", true, 0);
        GameStatus gameStatus = bridgeGame.getGameStatus();

        System.out.print("[ " + gameStatus.getUpBridge() + " ]");
        System.out.print("[ " + gameStatus.getDownBridge() + " ]");

        assertEquals("[   ][ O ]", out.toString());
    }

    @Test
    void move_메서드_아래_칸_실패_테스트() {
        bridgeGame.move("D", false, 0);
        GameStatus gameStatus = bridgeGame.getGameStatus();

        System.out.print("[ " + gameStatus.getUpBridge() + " ]");
        System.out.print("[ " + gameStatus.getDownBridge() + " ]");

        assertEquals("[   ][ X ]", out.toString());
    }

    @Test
    void retry_메서드_테스트() {
        assertTrue(bridgeGame.retry("R"));
        assertFalse(bridgeGame.retry("Q"));
    }
}