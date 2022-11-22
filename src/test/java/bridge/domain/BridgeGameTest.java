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
}