package bridge.view;

import bridge.exception.ErrorMsg;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;


class InputTest {
    PrintStream defaultOut = System.out;
    InputView inputView = new InputView();
    @AfterEach
    void setDefaultOut(){System.setOut(defaultOut);}

    @Test
    @DisplayName("입력 예외 테스트")
    public void inputException(){
        setInput("dddd");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("입력 예외 테스트")
    public void inputLowerBoundTest(){
        setInput("1");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 예외 테스트")
    public void inputUpperBoundTest(){
        setInput("21");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 예외 발생 시 다시 입력")
    public void loopInputTest(){
        OutputStream out = beforeTestOutput();
        setInput("aaa\n21\n20");

        Integer size = inputView.tryReadingInput(() -> inputView.readBridgeSize());

        assertThat(size).isEqualTo(20);
        assertThat(out.toString()).contains(ErrorMsg.WRONG_BRIDGE_SIZE.toString());
        assertThat(out.toString()).contains(ErrorMsg.NOT_NUMBER.toString());
    }

    private OutputStream beforeTestOutput() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}