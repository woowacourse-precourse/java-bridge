package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_길이_범위_테스트() {
        assertSimpleTest(() -> {
            runException("30");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리_길이_문자_테스트() {
        assertSimpleTest(() -> {
            runException("J");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new GameTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
