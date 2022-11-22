package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputExceptionTest {

    @Test
    void isCorrectBridgeInput() {
        String input = "10";
        InputException.isCorrectBridgeInput(input);

    }

    @Test
    void isCorrectBridgeLength() {
        String input = "21";
        assertThrows(IllegalArgumentException.class,
                () -> InputException.isCorrectBridgeLength(input));
    }

    @Test
    void isNumber() {
        String input = "1A";
        assertThrows(IllegalArgumentException.class,
                () -> InputException.isNumber(input));
    }

    @Test
    void isCorrectMoving() {
        String input = "A";
        assertThrows(IllegalArgumentException.class,
                () -> InputException.isNumber(input));
    }

    @Test
    void isCorrectRestartCommand() {
        String input = "D";
        assertThrows(IllegalArgumentException.class,
                () -> InputException.isNumber(input));
    }
}