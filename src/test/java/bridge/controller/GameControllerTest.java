package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

class GameControllerTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

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

}