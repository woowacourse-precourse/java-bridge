package bridge.inputViewTest;

import bridge.InputView;
import bridge.inputErrorHandle.InputException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ReadMovingTest {
    InputStream systemIn = System.in;
    ByteArrayInputStream testIn;
    InputView iv = new InputView();

    @Test
    void readMoving_예외_테스트_1() {

        String test = "DD";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readMoving();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(result).contains(InputException.DIRECTION_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    void readMoving_예외_테스트_2() {

        String test = "1";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readMoving();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(result).contains(InputException.DIRECTION_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void readMoving_기능_테스트_1() {

        String test = "U";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readMoving();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(test).contains("U");
    }

    @Test
    void readMoving_기능_테스트_2() {

        String test = "D";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            String x = iv.readMoving();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(test).contains("D");
    }

}