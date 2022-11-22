package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.model.BridgeMaker;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리_길이_범위_테스트")
    @Test
    void bridgeLengthRange() {
        assertSimpleTest(() -> {
            runException("30");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리_길이_문자_테스트")
    @Test
    void bridgeLengthString() {
        assertSimpleTest(() -> {
            runException("J");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리_길이_소수_테스트")
    @Test
    void bridgeLengthLong() {
        assertSimpleTest(() -> {
            runException("20.5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
