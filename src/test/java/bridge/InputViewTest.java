package bridge;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_길이_숫자_아닌_값_입력_테스트() {
        String inputBridgeSize = "a";
        assertSimpleTest(() -> {
            runException(inputBridgeSize);
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @Test
    void 다리_길이_범위_벗어난_값_입력_테스트() {
        String inputBridgeSize = "1";
        assertSimpleTest(() -> {
            runException(inputBridgeSize);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
