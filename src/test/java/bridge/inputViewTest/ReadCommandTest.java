package bridge.inputViewTest;

import bridge.InputView;
import bridge.inputErrorHandle.InputException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ReadCommandTest {
    InputStream systemIn = System.in;
    ByteArrayInputStream testIn;
    InputView iv = new InputView();

    @Test
    void readCommand_예외_테스트_1() {

        String test = "QQ";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readGameCommand();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(result).contains(InputException.COMMAND_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    void readCommand_예외_테스트_2() {

        String test = "D";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readGameCommand();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(result).contains(InputException.COMMAND_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void readCommand_기능_테스트_1() {

        String test = "R";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readGameCommand();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(test).contains("R");
    }

    @Test
    void readCommand_기능_테스트_2() {

        String test = "Q";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readGameCommand();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(test).contains("Q");
    }

}