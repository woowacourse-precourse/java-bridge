package bridge.view;

import bridge.exception.ErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;


class InputTest {
    InputView inputView = new InputView();

    @Test
    @DisplayName("숫자가 아님")
    public void inputException(){
        setInput("dddd");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("최소 길이보다 작음")
    public void inputLowerBoundTest(){
        setInput("1");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최대 길이보다 긺")
    public void inputUpperBoundTest(){
        setInput("21");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 예외 발생 시 다시 입력")
    public void loopInputTest(){
        setInput("22\n20");
        Integer size = inputView.tryReadingInput(() -> inputView.readBridgeSize());
        assertThat(size).isEqualTo(20);
    }

    @Test
    @DisplayName("숫자가 아닌 입력시 에러 문구 확인")
    public void notNumberErrorMsgTest(){
        testOutput("aaa\n20", ErrorMsg.NOT_NUMBER.toString(),
                () -> inputView.tryReadingInput(() -> inputView.readBridgeSize()));
    }

    @Test
    @DisplayName("입력범위를 넘어가는 경우 에러 문구 확인")
    public void outOfBoundErrorMsgTest(){
        testOutput("21\n20", ErrorMsg.WRONG_BRIDGE_SIZE.toString(),
                () -> inputView.tryReadingInput(() -> inputView.readBridgeSize()));
    }

    private <T> void testOutput(String input, String ouput, Supplier<T> function) {
        PrintStream defaultOut = System.out;
        OutputStream out = beforeTestOutput();

        setInput("aaa\n21\n20");
        function.get();
        assertThat(out.toString()).contains(ouput);

        printResult(defaultOut, out);
    }

    private void printResult(PrintStream defaultOut, OutputStream out) {
        String output = out.toString();
        System.setOut(defaultOut);
        System.out.println(output);
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