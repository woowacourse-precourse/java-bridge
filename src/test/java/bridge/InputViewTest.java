package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    InputView inputView = new InputView();

    @Test
    void readBridgeSize() {
        String test = "10";
        assertThat(inputView.readBridgeSize()).isEqualTo(10);
    }

    @Test
    void readMoving() {
        String test1 = "U";
        String test2 = "D";
        assertThat(inputView.readMoving()).isEqualTo("U");
        assertThat(inputView.readMoving()).isEqualTo("D");
    }

    @Test
    void readGameCommand() {
        String test1 = "R";
        String test2 = "Q";
        assertThat(inputView.readGameCommand()).isEqualTo("R");
        assertThat(inputView.readGameCommand()).isEqualTo("Q");
    }

}