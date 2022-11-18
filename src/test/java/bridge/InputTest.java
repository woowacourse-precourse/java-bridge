package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.AllBridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이로 문자가 입력되었을때")
    @Test
    void 다리길이_문자입력() {
        assertSimpleTest(() -> {
            runException("1a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이로 3~20이 아닐때")
    @Test
    void 다리길이_2_입력() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 잘못된_이동할칸_입력() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "A", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
