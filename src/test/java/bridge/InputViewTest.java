package bridge;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    public void 다리_길이_입력() {
        String input = "20";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(20, inputView.readBridgeSize());

        String inputError = "이십";
        OutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        InputStream in2 = new ByteArrayInputStream(inputError.getBytes());
        System.setIn(in2);
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);

        String inputError2 = "이십";
        OutputStream out3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out3));
        InputStream in3 = new ByteArrayInputStream(inputError2.getBytes());
        System.setIn(in3);
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }

}