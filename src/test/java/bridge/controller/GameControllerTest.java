package bridge.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameControllerTest {

    @Test
    void isValidBridgeNumber() {
        final String input = "qwo";
        final boolean instance = GameController.isValidBridgeNumber(input);
        assertTrue(instance);
    }

    @Test
    void isValidBridgeRange() {
        final String input = "23";
        final boolean instance = GameController.isValidBridgeRange(input);
        assertTrue(instance);
    }

    @Test
    void isValidBridgeAction() {
        final String input = "U";
        final boolean instance = GameController.isValidBridgeAction(input);
        assertFalse(instance);
    }

    @Test
    void isValidBridgeRestart() {
        final String input = "Q";
        final boolean instance = GameController.isValidBridgeRestart(input);
        assertFalse(instance);
    }

}