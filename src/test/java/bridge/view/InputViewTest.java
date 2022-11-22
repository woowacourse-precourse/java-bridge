package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.GameCommandNotAllowedException;
import bridge.exception.NotInputGameCommandException;
import bridge.exception.NotInputMovingOptionException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void readBridgeSize() {
    }

    @Test
    void readMoving_success() {
        String input = "U";
        mockIO(input);
        String result = inputView.readMoving();
        assertThat(input).isEqualTo(result);
    }

    @Test
    void readMoving_fail_not_input() {
        assertThatThrownBy(() -> {
            String input = "";
            mockIO(input);
            inputView.readMoving();
        }).isInstanceOf(NotInputMovingOptionException.class);
    }

    @Test
    void readMoving_fail_not_allowed() {
        assertThatThrownBy(() -> {
            String input = "A";
            mockIO(input);
            inputView.readMoving();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readGameCommand_success() {
        String input = "Q";
        mockIO(input);
        String result = inputView.readGameCommand();
        assertThat(input).isEqualTo(result);
    }

    @Test
    void readGameCommand_fail_not_input() {
        assertThatThrownBy(() -> {
            String input = "";
            mockIO(input);
            inputView.readGameCommand();
        }).isInstanceOf(NotInputGameCommandException.class);
    }

    @Test
    void readGameCommand_fail_not_allowed() {
        assertThatThrownBy(() -> {
            String input = "X";
            mockIO(input);
            inputView.readGameCommand();
        }).isInstanceOf(GameCommandNotAllowedException.class);
    }

    private void mockIO(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}