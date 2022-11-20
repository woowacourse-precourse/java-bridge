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
                .hasMessage(ExceptionMessage.sizeOverScope.getMessage());
    }

    @DisplayName("입력값이 숫자가 3 미만이면 예외를 발생한다.")
    @Test
    public void readSizeByUnderSize() {
        assertThatCode(() -> {
            setInput("2");
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.sizeOverScope.getMessage());
    }

    @DisplayName("이동거리가 U 일 때, 정상 작동")
    @Test
    public void checkMoveUpperWords() {
        assertThatCode(() -> {
            setInput("U");
            inputView.readMoving();
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동거리가 u 일 때, 정상 작동")
    @Test
    public void checkMoveLowerWords() {
        assertThatCode(() -> {
            setInput("u");
            inputView.readMoving();
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동거리가 U 또는 D가 아닐 경우 예외 발생")
    @Test
    public void checkMoveWordsNot() {
        assertThatCode(() -> {
            setInput("X");
            inputView.readMoving();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.moveByNotUD.getMessage());
    }

    @DisplayName("이동거리가 Q 일 때, 정상 종료")
    @Test
    public void checkCommandUpperWordsNot() {
        assertThatCode(() -> {
            setInput("Q");
            inputView.readGameCommand();
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동거리가 q 일 때, 정상 종료")
    @Test
    public void checkCommandLowerWordsNot() {
        assertThatCode(() -> {
            setInput("q");
            inputView.readGameCommand();
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동거리가 R 또는 Q가 아닐 경우 예외 발생")
    @Test
    public void checkCommandWordsNot() {
        assertThatCode(() -> {
            setInput("X");
            inputView.readGameCommand();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.commandByNotRQ.getMessage());
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}