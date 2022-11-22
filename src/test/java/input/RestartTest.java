package input;

import bridge.CustomException;
import ui.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class RestartTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 재시작테스트_빈칸() {
        assertSimpleTest(
                () -> {
                    run(" ", "R");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_BLANK);
                }
        );
    }

    @Test
    void 재시작테스트_긴명령() {
        assertSimpleTest(
                () -> {
                    run("RRRRRRR", "R");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.OUT_OF_COMMAND_RANGE);
                }
        );
    }

    @Test
    void 재시작테스트_빈칸_소문자() {
        assertSimpleTest(
                () -> {
                    run("r", "R");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_QUIT_RETRY);
                }
        );
    }

    @Test
    void 재시작테스트_유효하지않은명령() {
        assertSimpleTest(
                () -> {
                    run("a", "R");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_QUIT_RETRY);
                }
        );
    }

    @Override
    protected void runMain() {
        InputView inputView = new InputView();
        inputView.readGameCommand();
    }
}
