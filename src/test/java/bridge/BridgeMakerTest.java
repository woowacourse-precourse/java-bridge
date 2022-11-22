package bridge;

import bridge.model.BridgeMaker;
import bridge.constants.ErrorMessage;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest extends NsTest {
    @DisplayName("기본 다리 만들기")
    @Test
    void bridge_make_basic() {
        BridgeNumberGenerator numberGenerator = new GameTest.TestNumberGenerator(newArrayList(0, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "D", "D");
        assertThat(bridge.size()).isEqualTo(3);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
