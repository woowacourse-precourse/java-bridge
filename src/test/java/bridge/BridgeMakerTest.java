package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThat(bridgeMaker.makeBridge(3)).hasSize(3);
    }

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 예외_테스트_다리길이_음수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                bridgeMaker.makeBridge(-5);
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_다리길이_범위초과() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                bridgeMaker.makeBridge(1);
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
