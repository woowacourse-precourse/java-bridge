package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {
    private final String ERROR_MESSAGE = "[ERROR]";

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 다리_길이_입력_영어() {
        assertSimpleTest(() -> {
            runException("q");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이_입력_특수기호() {
        assertSimpleTest(() -> {
            runException("@");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이_입력_3_미만() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이_입력_20_초과() {
        assertSimpleTest(() -> {
            runException("99");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_건너기_방향_영어() {
        assertSimpleTest(() -> {
            runException("A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 게임_재시도_입력_예외() {
        assertSimpleTest(() -> {
            runException("q");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
}