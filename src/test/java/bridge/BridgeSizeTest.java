package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeSizeTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 예외_테스트_숫자가_아닌_경우_1() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_숫자가_아닌_경우_2() {
        assertSimpleTest(() -> {
            runException(".");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 생성 잘못된 입력")
    @Test
    void 예외_테스트_숫자_범위_미일치_1() {
        assertSimpleTest(() -> {
            runException("-3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_숫자_범위_미일치_2() {
        assertSimpleTest(() -> {
            runException("1231231823812381238277");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_숫자_범위_미일치_3() {
        assertSimpleTest(() -> {
            runException("7.3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
