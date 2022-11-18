package bridge.view.inputView;

import bridge.exception.ErrorMsg;
import bridge.utill.ConsoleTestUtil;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BridgeSizeInputTest {
    InputView inputView = new InputView();
    ConsoleTestUtil consoleTestUtil = new ConsoleTestUtil();

    @Test
    @DisplayName("숫자가 아님")
    public void inputException() {
        consoleTestUtil.setInput("dddd");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("최소 길이보다 작음")
    public void inputLowerBoundTest() {
        consoleTestUtil.setInput("1");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최대 길이보다 긺")
    public void inputUpperBoundTest() {
        consoleTestUtil.setInput("21");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 예외 발생 시 다시 입력")
    public void loopInputTest() {
        consoleTestUtil.setInput("22\n20");
        Integer size = inputView.loopInput(() -> inputView.readBridgeSize());
        assertThat(size).isEqualTo(20);
    }

    @Test
    @DisplayName("숫자가 아닌 입력시 에러 문구 확인")
    public void notNumberErrorMsgTest() {
        consoleTestUtil.testOutput("aaa\n20", ErrorMsg.WRONG_BRIDGE_SIZE.toString(),
                () -> inputView.loopInput(() -> inputView.readBridgeSize()));
    }

    @Test
    @DisplayName("입력범위를 넘어가는 경우 에러 문구 확인")
    public void outOfBoundErrorMsgTest() {
        consoleTestUtil.testOutput("21\n20", ErrorMsg.WRONG_BRIDGE_SIZE.toString(),
                () -> inputView.loopInput(() -> inputView.readBridgeSize()));
    }
}