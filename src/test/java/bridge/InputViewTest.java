package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputViewTest {

    private final InputView view = new InputView();

    @Test
    @DisplayName("read_bridge_size_success_test")
    void read_bridge_size_success_test() {
        view.validateNumber("3");
    }

    @Test
    @DisplayName("read_moving_success_test")
    void read_moving_success_test() {
        view.validateMovingInput("U");
        view.validateMovingInput("D");

    }

    @Test
    @DisplayName("read_game_success_command")
    void read_game_success_command() {
        view.validateGameInput("Q");
        view.validateGameInput("R");
    }

    @Test
    @DisplayName("read_bridge_size_fail_test")
    void read_bridge_size_fail_test() {
        Assertions.assertThrows(InputException.class,() -> view.validateNumber("a"));
    }

    @Test
    @DisplayName("read_moving_fail_test")
    void read_moving_fail_test() {
        Assertions.assertThrows(InputException.class,() -> view.validateMovingInput("a"));

    }

    @Test
    @DisplayName("read_game_fail_command")
    void read_game_fail_test() {
        Assertions.assertThrows(InputException.class,() -> view.validateGameInput("a"));
    }
}