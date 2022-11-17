package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputStream in;
    InputView inputView;

    @BeforeEach
    void setIn() {
        inputView = new InputView();
    }

    @DisplayName("정상 입력 값 확인")
    @Test
    void normalCase() {
        String input = "4";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputView.readBridgeSize())
                .isEqualTo(4);
    }

    @DisplayName("예외 값 입력 확인")
    @Test
    void exceptionCase() {
        String input = "2\n4";
        String error = "[ERROR]";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        inputView.readBridgeSize();
        assertThat(out.toString()).contains(error);
    }

    @DisplayName("정상 재입력 확인")
    @Test
    void reInput() {
        String input = "2\n4";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(4);
    }
}
