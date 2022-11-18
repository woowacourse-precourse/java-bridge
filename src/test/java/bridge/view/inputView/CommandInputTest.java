package bridge.view.inputView;

import bridge.exception.ErrorMsg;
import bridge.utill.ConsoleTestUtil;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandInputTest {
    InputView inputView = new InputView();
    ConsoleTestUtil consoleTestUtil = new ConsoleTestUtil();

    @Test
    @DisplayName("올바른 입력 테스트")
    public void movementInputTest() {
        consoleTestUtil.setInput("R");
        String move = inputView.readGameCommand();
        assertThat(move).isEqualTo("R");
    }


    @Test
    @DisplayName("command 예외 테스트")
    public void movementException() {
        consoleTestUtil.setInput("19");
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("반복 입력 테스트 - 잘못된 입력 예외 출력")
    public void movementLoopInputException() {
        consoleTestUtil.testOutput("RR\nQ", ErrorMsg.NOT_ALLOWED_COMMAND.toString(),
                () -> inputView.loopInput(() -> inputView.readGameCommand()));
    }

    @Test
    @DisplayName("반복 입력 테스트 - 값 테스트")
    public void movementLoopInput() {
        consoleTestUtil.setInput("A\nQ");
        String move = inputView.loopInput(() -> inputView.readGameCommand());
        assertThat(move).isEqualTo("Q");
    }
}
