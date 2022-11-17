package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatCode;

class InputViewTest {

    private final Validator validator = new Validator();
    private final InputView inputView = new InputView(validator);

    @DisplayName("정상 작동한다.")
    @Test
    public void readSize_Success() {
        assertThatCode(() -> {
            setInput("5");
            int size = inputView.readBridgeSize();

            if (size != 5) throw new IllegalArgumentException();

        }).doesNotThrowAnyException();
    }


    @DisplayName("입력값이 숫자가 아닌 경우 예외를 발생한다.")
    @Test
    public void readSizeByDuplicatedNumber() {
        assertThatCode(() -> {
            setInput("a");
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.incorrectSize.getMessage());
    }

    @DisplayName("입력값이 숫자가 20 초과면 예외를 발생한다.")
    @Test
    public void readSizeByOverSize() {
        assertThatCode(() -> {
            setInput("21");
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.incorrectSize.getMessage());
    }

    @DisplayName("입력값이 숫자가 3 미만이면 예외를 발생한다.")
    @Test
    public void readSizeByUnderSize() {
        assertThatCode(() -> {
            setInput("2");
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.incorrectSize.getMessage());
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}