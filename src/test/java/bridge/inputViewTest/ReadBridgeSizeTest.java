package bridge.inputViewTest;

import bridge.InputView;
import bridge.inputErrorHandle.InputException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ReadBridgeSizeTest {
    InputStream systemIn = System.in;
    ByteArrayInputStream testIn;
    InputView iv = new InputView();

    @Test
    void bridgeSize_예외_테스트_1() {

        String test = "2";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            int x = iv.readBridgeSize();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(result).contains(InputException.NUMBER_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void bridgeSize_예외_테스트_2() {

        String test = "21";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            int x = iv.readBridgeSize();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(result).contains(InputException.NUMBER_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void bridgeSize_예외_테스트_3() {

        String test = "a";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            int x = iv.readBridgeSize();
        } catch (Exception e) {
            result = e.getMessage();
        }

        assertThat(result).contains(InputException.NUMBER_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    void bridgeSize_기능_테스트_1() {

        String test = "15";
        testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        String result = "";
        try {
            int x = iv.readBridgeSize();
        } catch (Exception e) {
            result = e.getMessage();
        }

        System.out.println(result);
        assertThat(test).contains("15");
    }





}