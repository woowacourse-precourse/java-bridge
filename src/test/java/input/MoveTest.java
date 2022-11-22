package input;

import bridge.CustomException;
import ui.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class MoveTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 이동명령테스트_빈칸() {
        assertSimpleTest(
                () -> {
                    run(" ", "D");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_BLANK);
                }
        );
    }

    @Test
    void 이동명령테스트_긴이동명령() {
        assertSimpleTest(
                () -> {
                    run("DDDD", "D");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.OUT_OF_MOVE_RANGE);
                }
        );
    }

    @Test
    void 이동명령테스트_유효하지않은이동() {
        assertSimpleTest(
                () -> {
                    run("a", "D");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_MOVING_COMMAND);
                }
        );
    }

    @Test
    void 이동명령테스트_소문자() {
        assertSimpleTest(
                () -> {
                    run("d", "D");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_MOVING_COMMAND);
                }
        );
    }

    @Override
    protected void runMain() {
        InputView inputView = new InputView();
        inputView.readMoving();
    }
}
