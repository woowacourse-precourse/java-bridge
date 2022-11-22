package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void moveUpFailTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U", "D"));
        String direction = "U";

        bridgeGame.move(direction);

        assertEquals(List.of("[", " X ", "|"), bridgeGame.getUpBridge());
    }

    @Test
    void moveUpSuccessTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "D"));
        String direction = "U";

        bridgeGame.move(direction);

        assertEquals(List.of("[", " O ", "|"), bridgeGame.getUpBridge());
    }

    @Test
    void moveDownFailTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "D"));
        String direction = "D";

        bridgeGame.move(direction);

        assertEquals(List.of("[", " X ", "|"), bridgeGame.getDownBridge());
    }

    @Test
    void moveDownSuccessTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U", "D"));
        String direction = "D";

        bridgeGame.move(direction);

        assertEquals(List.of("[", " O ", "|"), bridgeGame.getDownBridge());
    }

    @Test
    void IsFailedMethodFailedTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U", "D"));
        String direction = "U";
        bridgeGame.move(direction);

        boolean actual = bridgeGame.isFailed();

        assertTrue(actual);
    }

}