package bridge;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_길이_숫자_아닌_값_입력_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @Test
    void 다리_길이_범위_벗어난_값_입력_테스트() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 올바르지_않은_다리_이동_값_입력_테스트() {
        assertSimpleTest(() -> {
            runException("3", "A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 올바르지_않은_게임_명령어_입력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "D", "D", "A");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
