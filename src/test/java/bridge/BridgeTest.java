package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_길이_입력_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
