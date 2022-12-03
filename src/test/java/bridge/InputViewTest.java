package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;



public class InputViewTest extends NsTest {
    private final String ERROR_MESSAGE = "[ERROR]";

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 다리_길이_입력_알파벳() {
        assertSimpleTest(() -> {
            runException("12AB");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리_길이_입력_특수기호() {
        assertSimpleTest(() -> {
            runException("12!");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리_길이_입력_실수() {
        assertSimpleTest(() -> {
            runException("3.5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리_길이_입력_3미만() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리_길이_입력_20초과() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_건너기_방향_NON_UD() {
        assertSimpleTest(() -> {
            runException("3","A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리_건너기_방향_NON_UD2() {
        assertSimpleTest(() -> {
            runException("3","아래");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 게임_재시도_입력_NON_RQ() {
        assertSimpleTest(() -> {
            runException("3","U","U","A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 게임_재시도_입력_NON_RQ2() {
        assertSimpleTest(() -> {
            runException("3","U","U","1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
}
