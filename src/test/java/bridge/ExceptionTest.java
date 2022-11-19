package bridge;

import org.junit.jupiter.api.Test;

import static bridge.exeption.ExceptionMessage.NOT_NUM_ERROR;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends ApplicationTest{
    @Test
    void 숫자가_아닌_값_입력시() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(NOT_NUM_ERROR.getError());
        });
    }
    @Test
    void U_또는_D_외_입력시() {
        assertSimpleTest(() -> {
            runException("1","R");
            assertThat(output()).contains(NOT_NUM_ERROR.getError());
        });
    }
}
