package bridge.domain;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_입력_예외1() {
        assertSimpleTest(() -> {
            runException("tt");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_입력_예외2() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_입력_예외3() {
        assertSimpleTest(() -> {
            runException("23");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    protected void runMain() {
        Application.main(new String[]{});
    }


}
