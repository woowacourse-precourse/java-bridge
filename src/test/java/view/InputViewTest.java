package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class InputViewTest {
    private InputView inputView;
    private OutputStream out;
    private InputStream in;

    @BeforeEach
    void beforeEach(){
        this.inputView = new InputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void readBridgeSize() {
        String input = "30" + System.lineSeparator() + "5";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int size = inputView.readBridgeSize();

        assertThat(size).isEqualTo(5);
        assertThat(out.toString().trim())
                .contains(
                        "[ERROR]"
                );
    }

    @Test
    void validateBridgeSize() {
        assertThatThrownBy(() -> inputView.validateBridgeSize(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readMoving() {
        String input = "d" + System.lineSeparator() + "U";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String move = inputView.readMoving();

        assertThat(move).isEqualTo("U");
        assertThat(out.toString().trim())
                .contains(
                        "[ERROR]"
                );
    }

    @Test
    void readGameCommand() {
        String input = "RRR" + System.lineSeparator() + "Q";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean keepGoing = inputView.readGameCommand();

        assertThat(keepGoing).isEqualTo(false);
        assertThat(out.toString().trim())
                .contains(
                        "[ERROR]"
                );
    }
}