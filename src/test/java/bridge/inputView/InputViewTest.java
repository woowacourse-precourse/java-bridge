package bridge.inputView;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.common.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest extends NsTest {
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "1"})
    void readGameCommandErrorTest(String input) {
        try {

            final byte[] buf = String.join("\n", input).getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            String expected = new InputView().readGameCommand();
        } catch (NoSuchElementException e) {
        } finally {
            assertThat(output()).contains(ErrorMessage.ILLEGAL_READ_GAME_COMMAND.getTagMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void readGameCommandRunTest(String input) {
        String expected = null;
        String result = input;
        try {
            final byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            expected = new InputView().readGameCommand();
        } catch (NoSuchElementException e) {
        } finally {
            assertThat(expected).isEqualTo(result);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "1"})
    void readMovingErrorTest(String input) {
        try {

            final byte[] buf = String.join("\n", input).getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            String expected = new InputView().readMoving();
        } catch (NoSuchElementException e) {
        } finally {
            assertThat(output()).contains(ErrorMessage.ILLEGAL_READ_MOVING.getTagMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"D", "U"})
    void readMovingRunTest(String input) {
        String expected = null;
        String result = input;
        try {
            final byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            expected = new InputView().readMoving();
        } catch (NoSuchElementException e) {
        } finally {
            assertThat(expected).isEqualTo(result);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "2", "21"})
    void readBridgeSizeErrorTest(String input) {
        try {

            final byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            int expected = new InputView().readBridgeSize();
        } catch (NoSuchElementException e) {
        } finally {
            assertThat(output()).contains(ErrorMessage.ILLEGAL_READ_BRIDGE_SIZE.getTagMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void readBridgeSizeRunTest(String input) {
        int expected = -1;
        String result = input;
        try {
            final byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            expected = new InputView().readBridgeSize();
        } catch (NoSuchElementException e) {
        } finally {
            assertThat(expected).isEqualTo(Integer.valueOf(result));
        }
    }


    @Override
    protected void runMain() {

    }
}