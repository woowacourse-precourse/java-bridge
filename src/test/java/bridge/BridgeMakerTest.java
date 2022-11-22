package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeNumberGenerator;
import bridge.ApplicationTest.TestNumberGenerator;
import bridge.model.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리 생성 후 저장 및 불러오기")
    @Test
    void 다리_저장_불러오기() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeMaker.makeBridge(4);
        assertThat(bridgeMaker.getBridge()).containsExactly("D", "D", "U", "U");
    }
}