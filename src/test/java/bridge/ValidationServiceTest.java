package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

    @Test
    public void bridgeLengthWrongInputTest() {
        List<String> inputs = List.of("2", "21", "test");
        for (String input : inputs) {
            assertThrows(IllegalArgumentException.class, () -> {
                ValidationService.checkBridgeLength(input);
            });
        }
    }

    @Test
    public void bridgeLengthCorrectInputTest() {
        List<String> inputs = List.of("3", "20", "4");
        for (String input : inputs) {
                ValidationService.checkBridgeLength(input);
            };
        }


    @Test
    public void checkMoveCommandWrongInputTest() {
        List<String> inputs = List.of("u", "d", "`1");
        for (String input : inputs) {
            IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class, () -> {
                ValidationService.checkMoveCommand(input);
            });
        }
    }

    @Test
    public void checkMoveCommandCorrectInputTest() {
        List<String> inputs = List.of("U", "D");
        for (String input : inputs) {
                ValidationService.checkMoveCommand(input);
            };
        }


    @Test
    public void checkGameCommandWrongInputTest() {
        List<String> inputs = List.of("q", "r", "`1");
        for (String input : inputs) {
            IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class, () -> {
                ValidationService.checkMoveCommand(input);
            });
        }
    }
    @Test
    public void checkGameCommandCorrectInputTest() {
        List<String> inputs = List.of("Q", "R");
        for (String input : inputs) {
                ValidationService.checkGameCommand(input);
            };
        }
    }

