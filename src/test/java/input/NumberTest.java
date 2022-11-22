package input;

import bridge.CustomException;
import ui.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class NumberTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리길이테스트_빈칸() {
        assertSimpleTest(
                () -> {
                    run(" ", "3");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_BLANK);
                }
        );
    }

    @Test
    void 다리길이테스트_0으로시작하는수() {
        assertSimpleTest(
                () -> {
                    run("03", "3");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.NOT_START_ZERO);
                }
        );
    }

    @Test
    void 다리길이테스트_초과범위() {
        assertSimpleTest(
                () -> {
                    run("21", "3");
                    assertThat(output()).contains(ERROR_MESSAGE, CustomException.OUT_OF_RANGE);
                }
        );
    }

    @Override
    protected void runMain() {
        InputView inputView = new InputView();
        inputView.readBridgeSize();
    }
}
