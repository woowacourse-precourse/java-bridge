package bridge;

import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputStream in;
    InputView inputView;
    String error = "[ERROR]";

    @BeforeEach
    void setIn() {
        inputView = new InputView();
    }

    @DisplayName("사이즈 정상 입력 값 확인")
    @Test
    void normalCase() {
        String input = "4";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputView.readBridgeSize())
                .isEqualTo(4);
    }

    @DisplayName("사이즈 예외 값 입력 확인")
    @Test
    void exceptionCase() {
        String input = "2\n4";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        inputView.readBridgeSize();
        assertThat(out.toString()).contains(error);
    }

    @DisplayName("사이즈 정상 재입력 확인")
    @Test
    void reInput() {
        String input = "2\n4";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(4);
    }

    @DisplayName("다리 이동 예외 입력")
    @Test
    void moveException() {
        String input = "r";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            inputView.readMoving();
        } catch (NoSuchElementException e) {
            assertThat(out.toString()).contains(error);
        }
    }

    @DisplayName("재시작 입력 예외")
    @Test
    void restartException() {
        String input = "r";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            inputView.readGameCommand();
        } catch (NoSuchElementException e) {
            assertThat(out.toString()).contains(error);
        }
    }
}
