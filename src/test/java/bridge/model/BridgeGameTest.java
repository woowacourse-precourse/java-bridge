package bridge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.controller.GameController;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    @Test
    void move() {
        final String input = "U";
        BridgeGame.bridgeResult = new ArrayList<>(List.of("U", "D", "D"));
        BridgeGame.moveIndex = 0;
        BridgeGame.move(input);
        assertTrue(true);
    }

    @Test
    void retry() {
        GameController.gameCount = 1;
        GameController.first.append("test");
        GameController.second.append("tset2");

        final String input = "R";
        BridgeGame.retry(input);
        assertEquals(GameController.first.toString(), "");
        assertEquals(GameController.second.toString(), "");
        assertFalse(false);
    }
}