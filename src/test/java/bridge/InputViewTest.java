package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatCode;

class InputViewTest {
    private final Validator validator = new Validator();
    private final InputView inputView = new InputView(validator);

    @DisplayName("정상 작동한다.")
    @ParameterizedTest
    @CsvSource(value = {"3", "5", "13", "20"})
    public void readSize_Success(String inputSize) {
        assertThatCode(() -> {
            setInput(inputSize);
            int size = inputView.readBridgeSize();

            if (size != Integer.parseInt(inputSize)) {
                throw new IllegalArgumentException();
            }

        }).doesNotThrowAnyException();
    }

    @DisplayName("입력값이 숫자가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"a", "-", "*", "~"})
    public void readSizeByDuplicatedNumber(String inputSize) {
        assertThatCode(() -> {
            setInput(inputSize);
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.incorrectSize.getMessage());
    }

    @DisplayName("입력값이 숫자가 20 초과면 예외를 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"21", "25", "100", "1000"})
    public void readSizeByOver(String inputSize) {
        assertThatCode(() -> {
            setInput(inputSize);
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.sizeOverScope.getMessage());
    }

    @DisplayName("입력값이 숫자가 3 미만이면 예외를 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"2", "-5", "0", "-100"})
    public void readSizeByUnder(String inputSize) {
        assertThatCode(() -> {
            setInput(inputSize);
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.sizeOverScope.getMessage());
    }

    @DisplayName("이동거리가 U or D 일 때, 정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"U", "u", "D", "d"})
    public void checkMoveWords(String inputMove) {
        assertThatCode(() -> {
            setInput(inputMove);
            inputView.readMoving();
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동거리가 U 또는 D가 아닐 경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"a", "A", "x", "X", "uu", "Uu", "DD"})
    public void checkNotMoveWords(String inputMove) {
        assertThatCode(() -> {
            setInput(inputMove);
            inputView.readMoving();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.moveByNotUD.getMessage());
    }

    @DisplayName("명령이 정상 일 때, 정상 종료")
    @ParameterizedTest
    @CsvSource(value = {"r", "R", "Q", "q"})
    public void checkCommandWords(String inputCommand) {
        assertThatCode(() -> {
            setInput(inputCommand);
            inputView.readGameCommand();
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동거리가 R 또는 Q가 아닐 경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"a", "x", "w", "E", "rR", "qQ"})
    public void checkCommandWordsNot(String inputCommand) {
        assertThatCode(() -> {
            setInput(inputCommand);
            inputView.readGameCommand();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.commandByNotRQ.getMessage());
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}