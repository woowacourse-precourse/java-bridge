package bridge.ioView;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리길이입력_숫자아님() {
        assertSimpleTest(() -> {
            runException("  a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리길이입력_3부터_20아님() {
        assertSimpleTest(() -> {
            runException("25");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}