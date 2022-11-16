package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoveTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 이동_숫자_테스트() {
        assertSimpleTest(() -> {
            runException("3", "123");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 이동입력_길이_테스트() {
        assertSimpleTest(() -> {
            runException("3", "qwe");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 이동_유효_테스트() {
        assertSimpleTest(() -> {
            runException("3", "u");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
