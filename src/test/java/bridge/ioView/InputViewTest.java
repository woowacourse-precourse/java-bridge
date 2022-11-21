package bridge.ioView;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리길이입력_숫자아님")
    @Test
    void 다리길이입력_숫자아님() {
        assertSimpleTest(() -> {
            runException("  a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리길이입력_3부터_20아님")
    @Test
    void 다리길이입력_3부터_20아님() {
        assertSimpleTest(() -> {
            runException("25");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("움직임입력_U나_D아님")
    @Test
    void 움직임입력_U나_D아님() {
        assertSimpleTest(() -> {
            runException("20","U","D","u");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("게임명령어입력_R이나_Q아님")
    @Test
    void 게임명령어입력_R이나_Q아님() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "r");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}