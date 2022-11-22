package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.*;

import org.junit.jupiter.api.Test;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/22
 */
public class InputViewTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void readBridgeSizeByCorrect() {
        InputView inputView = new InputView();
        InputStream in = generateUserInput("5");
        System.setIn(in);
        int bridgeSize = inputView.readBridgeSize();
        assertThat(bridgeSize).isEqualTo(5);
    }

    @Test
    void readMovingByCorrect() {
        InputView inputView = new InputView();
        InputStream in = generateUserInput("U");
        System.setIn(in);
        String bridgeSize = inputView.readMoving();
        assertThat(bridgeSize).isEqualTo("U");
    }

    @Test
    void readGameCommandByCorrect() {
        InputView inputView = new InputView();
        InputStream in = generateUserInput("Q");
        System.setIn(in);
        String bridgeSize = inputView.readGameCommand();
        assertThat(bridgeSize).isEqualTo("Q");
    }
}
