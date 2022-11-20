package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static bridge.support.ErrorMessage.BRIDGE_MAKER_SIZE_ERROR;
import static bridge.support.ErrorMessage.INVALID_BRIDGE_UNIT_CODE_ERROR;
import static bridge.support.ErrorMessage.INVALID_COMMAND_ERROR;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_길이가_3_20_사이의_값이_아닐_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE + " " + BRIDGE_MAKER_SIZE_ERROR);
        });
    }

    @Test
    void 이동_입력_시_D_또는_U_이외의_값이_들어오는_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("3", "T");
            assertThat(output()).contains(ERROR_MESSAGE + " " + INVALID_BRIDGE_UNIT_CODE_ERROR);
        });
    }

    @Test
    void 재시작_여부_입력_시_R_또는_Q_이외의_값이_들어오는_경우_예외가_발생한다() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "T");
            assertThat(output()).contains(ERROR_MESSAGE + " " + INVALID_COMMAND_ERROR);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
