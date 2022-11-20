package bridge;

import org.junit.jupiter.api.Test;

import static bridge.exeption.ExceptionMessage.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
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
            runException("3","R");
            assertThat(output()).contains(MOVE_INPUT_ERROR.getError());
        });
    }
    @Test
    void 재시작_입력_오류() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D","Q");
            assertThat(output()).contains(RETRY_INPUT_ERROR.getError()
            );
        }, 1,0,1);
    }
    @Test
    void 다리_갯수_입력_오류() {
        assertRandomNumberInRangeTest(() -> {
            run("2", "21","3", "U", "U", "U");
            assertThat(output()).contains(OUT_OF_RANGE_INPUT_ERROR.getError()
            );
        }, 1,1,1);
    }
}
