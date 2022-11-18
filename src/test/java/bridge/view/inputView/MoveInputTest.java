package bridge.view.inputView;

import bridge.exception.ErrorMsg;
import bridge.utill.ConsoleTestUtil;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveInputTest {
    InputView inputView = new InputView();
    ConsoleTestUtil consoleTestUtil = new ConsoleTestUtil();

    @Test
    @DisplayName("올바른 입력 테스트")
    public void movementInputTest() {
        consoleTestUtil.setInput("U");
        String move = inputView.readMoving();
        assertThat(move).isEqualTo("U");
    }


    @Test
    @DisplayName("사용자 이동 예외 테스트")
    public void movementException() {
        consoleTestUtil.setInput("R");
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("반복 입력 테스트 - 잘못된 이동값 예외 출력")
    public void movementLoopInputException() {
        consoleTestUtil.testOutput("R\nU", ErrorMsg.NOT_ALLOWED_MOVEMENT.toString(),
                () -> inputView.loopInput(() -> inputView.readMoving()));
    }

    @Test
    @DisplayName("반복 입력 테스트 - 값 테스트")
    public void movementLoopInput() {
        consoleTestUtil.setInput("A\nU");
        String move = inputView.loopInput(() -> inputView.readMoving());
        assertThat(move).isEqualTo("U");
    }
}
